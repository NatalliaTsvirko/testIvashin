package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    private static final By BANNER_IMAGE = By.xpath("//img[@class='banner-image']");
    private String cards = "//div[@class='card-body']/h5[text()='%s']";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(BANNER_IMAGE);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Click elements card")
    public void clickCard(String nameCard) {

        jsClick(driver.findElement(By.xpath(String.format(cards, nameCard))));
    }
}
