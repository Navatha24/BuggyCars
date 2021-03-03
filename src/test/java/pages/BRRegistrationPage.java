package pages;

import cucumber.api.DataTable;
import fixture.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BRRegistrationPage extends PageObject {

    @FindBy(xpath = "//*[text()='Register with Buggy Cars Rating']")
    private WebElement registrationPage;

    @FindBy(id = "username")
    private WebElement usernameTextBox;

    @FindBy(id = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    private WebElement lastNameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordTextBox;

    @FindBy(css = ".btn.btn-default")
    private WebElement registerButton;

    @FindBy(css = ".result.alert.alert-success")
    private WebElement registrationSuccessMessage;

    public BRRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationpageDisplayed(){
        return registrationPage.isDisplayed();
    }

    public BRRegistrationPage clickRegister(){
        registerButton.click();
        return new BRRegistrationPage(driver);
    }

    public void  enterRegistrationDetails(DataTable table){

        List<List<String>> data = table.raw();
        usernameTextBox.sendKeys(data.get(1).get(1)+getRandomNumber());
        firstNameTextBox.sendKeys(data.get(2).get(1));
        lastNameTextBox.sendKeys(data.get(3).get(1));
        passwordTextBox.sendKeys(data.get(4).get(1));
        confirmPasswordTextBox.sendKeys(data.get(5).get(1));
    }

    public String displaySuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".result.alert.alert-success"))));
        return registrationSuccessMessage.getText();
    }

    public static double getRandomNumber(){
        double x = Math.random();
        return x;
    }

    @Override
    protected ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(registrationPage);
    }
}
