package pages;

import fixture.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BRLoginPage extends PageObject {

	@FindBy(css = ".btn.btn-success")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement usernameTextBox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextBox;

	@FindBy(css = ".span.label.label-warning")
	private WebElement errorMessage;

	@FindBy(css = ".btn.btn-success-outline")
	private WebElement registrationButton;

	public BRLoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isLogInButtonDisplayed() {
		return loginButton.isDisplayed();
	}

	public BRHomePage clickLogin(){
		loginButton.click();
		return new BRHomePage(driver);
	}

	public BRLoginPage clickErrorLogin(){
		loginButton.click();
		return new BRLoginPage(driver);
	}

	public BRRegistrationPage clickRegister(){
		registrationButton.click();
		return new BRRegistrationPage(driver);
	}

	public String getErrorMessageForInvalidLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".span.label.label-warning"))));
		return errorMessage.getText();
	}

	public void enterLoginDetails(String username, String password){
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	@Override
	protected ExpectedCondition<?> pageIsLoaded(Object... params) {
		return ExpectedConditions.visibilityOf(loginButton);
	}


}
