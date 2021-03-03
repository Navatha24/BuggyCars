package pages;

import fixture.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BRHomePage extends PageObject {

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	private WebElement logOut;

	@FindBy(xpath = "//*[contains(text(),'Profile')]")
	private WebElement profile;

	@FindBy(css = ".img-fluid.center-block")
	private List<WebElement> registeredUserLink;

	public BRHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLogOutButtonDisplayed() {
		return logOut.isDisplayed();
	}

	public BRLoginPage clickLogout(){
		logOut.click();
		return new BRLoginPage(driver);
	}

	public BRProfilePage clickProfile(){
        profile.click();
        return new BRProfilePage(driver);
    }

    public void clickListOfRegisteredUsers(){
		registeredUserLink.get(2).click();
	}

    public HashMap<String,String>listOfallElements() {

		HashMap<String,String> modelData=new HashMap<>();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("table.cars.table.table-hover"))));

		WebElement table = driver.findElement(By.cssSelector("table.cars.table.table-hover"));
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));

		for (int i = 1; i < rowsList.size(); i++) {
			List<WebElement> colVals = rowsList.get(i).findElements(By.tagName("td"));
			String colValue="";
			for (int j = 0; j <colVals.size(); j++) {
				colValue = colValue+colVals.get(j).getText()+";;";
			}
			modelData.put(i+"",colValue);
		}
		//System.out.println("Car Table Data:"+modelData);
		return modelData;
	}

	@Override
	protected ExpectedCondition<?> pageIsLoaded(Object... params) {
		return ExpectedConditions.visibilityOf(logOut);
	}


}
