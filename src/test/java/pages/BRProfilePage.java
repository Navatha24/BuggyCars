package pages;

import fixture.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BRProfilePage extends PageObject {

    @FindBy(xpath = "//*[contains(text(),'Additional Info')]")
    private WebElement additionalInfo;

    @FindBy(id = "hobby")
    private WebElement hobby;

    @FindBy(xpath = "//*[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(css = ".result.alert.alert-success")
    private WebElement confirmationMessage;

    public BRProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void updateHobby(String updatedHobby) {
        Select hobbyList=new Select(hobby);
        hobbyList.selectByVisibleText(updatedHobby);
    }

    public String getDefaultHobbyDisplay() {
        Select hobbyList=new Select(hobby);
        return hobbyList.getFirstSelectedOption().getText();
    }

    public void clickSave() {
        saveButton.click();
    }

    public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".result.alert.alert-success"))));
        return confirmationMessage.getText();
    }

    @Override
    protected ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(additionalInfo);
    }

}
