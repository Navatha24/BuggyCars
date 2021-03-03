package fixture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

	protected final WebDriver driver;

	protected PageObject(WebDriver driver, Object... params) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForPageToLoad(driver, params);
	}

	private void waitForPageToLoad(WebDriver driver, Object... params) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageIsLoaded(params));
	}

	/**
	 * Returns a condition that checks whether the page is loaded. This is
	 * called when constructing a new PageObject to check that it is in sync
	 * with the browser.
	 * <p/>
	 * Since WebDriver can return prior to a page being fully loaded, this
	 * condition must be unique to the page being loaded and must not be met by
	 * the previous page that we are transferring from.
	 */
	protected abstract ExpectedCondition<?> pageIsLoaded(Object... params);

}
