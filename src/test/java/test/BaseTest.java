package test;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    @Step("Open browser")
    public void setUp(ITestContext testContext, @Optional("chrome") String browser) {

        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);

    }

    @AfterClass(alwaysRun = true)
    @Step("Close browser")
    public void tearDown() {
        driver.quit();
    }
}
