package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

@Log4j2
public abstract class BasePage {

    String BASE_URL = System.getenv().getOrDefault("BASE_URL", PropertyReader.getProperty("demoqa.base_url"));

    WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isPageOpened();

    public abstract BasePage open();

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
