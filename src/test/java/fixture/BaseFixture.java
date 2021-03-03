package fixture;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BRLoginPage;

public class BaseFixture {
	
	protected static WebDriver driver = new ChromeDriver();
    private static final String URL = "https://buggy.justtestit.org/";

    @AfterClass
    public static void tearDown() {
    	driver.quit();
    }

    public static BRLoginPage navigateToBRLoginPage() {
        driver.get(URL);
        return new BRLoginPage(driver);
    }

}
