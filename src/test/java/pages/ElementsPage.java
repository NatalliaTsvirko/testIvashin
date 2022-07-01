package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ElementsPage extends BasePage {


    private static final By TOOLSQA_LABLE = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private static final By CHECKBOX = By.xpath("//span[@class='rct-checkbox']");
    private static final By SUCCESS_MESSAGE = By.xpath("//span[text()='You have selected :']");
    private static final By SUCCESS_MESSAGE_RADIO_BUTTON = By.xpath("//p[text()='You have selected ']");
    private String optionElements = "//ul[@class='menu-list']//span[@class='text' and text()='%s']";
    private String radioButton = "//label[@for='%s']";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TOOLSQA_LABLE);
    }

    @Override
    public ElementsPage open() {
        driver.get(BASE_URL + "/elements");
        return this;
    }

    @Step("Select elements from navigator bar")
    public ElementsPage selectElementsFromNavigatorBar(String optionName) {
        log.info("Select elements from navigator bar");
        driver.findElement(By.xpath(String.format(optionElements, optionName))).click();
        return this;
    }

    @Step("Select checkbox element")
    public ElementsPage selectCheckbox() {
        log.info("Select checkbox");
        driver.findElement(CHECKBOX).click();
        return this;
    }

    @Step("Select radiobutton element")
    public ElementsPage selectRadiobutton(String optionName) {
        log.info("Select radiobutton");
        driver.findElement(By.xpath(String.format(radioButton, optionName))).click();
        return this;
    }

    @Step("Verify notification message ")
    public boolean isNotificationMessageDisplayedCheckbox() {
        log.info("verify notification message after selected checkbox");
        return driver.findElement(SUCCESS_MESSAGE).isDisplayed();
    }

    @Step("Verify notification message ")
    public boolean isNotificationMessageDisplayedRadioButton() {
        log.info("verify notification message after selected radiobutton");
        return driver.findElement(SUCCESS_MESSAGE_RADIO_BUTTON).isDisplayed();
    }
}
