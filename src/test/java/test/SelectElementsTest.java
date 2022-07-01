package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import utils.AllureUtils;

public class SelectElementsTest extends BaseTest {

    ElementsPage elementsPage;

    @BeforeClass
    public void initializePages() {
        elementsPage = new ElementsPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        homePage.open().isPageOpened();
    }

    @Test(description = "Select checkbox and radiobutton")
    public void selectElement() {
        String checkboxOption = "Check Box";
        String radioButton = "Radio Button";
        String elementCard = "Elements";
        String radioButtonImpressive = "impressiveRadio";
        String radioButtonYes = "yesRadio";
        homePage.clickCard(elementCard);
        elementsPage.selectElementsFromNavigatorBar(checkboxOption)
                .selectCheckbox();
        Assert.assertTrue(elementsPage.isNotificationMessageDisplayedCheckbox());
        AllureUtils.attachScreenshot(driver);
        elementsPage.selectElementsFromNavigatorBar(radioButton)
                .selectRadiobutton(radioButtonImpressive);
        Assert.assertTrue(elementsPage.isNotificationMessageDisplayedRadioButton());
        elementsPage.selectRadiobutton(radioButtonYes);
        Assert.assertTrue(elementsPage.isNotificationMessageDisplayedRadioButton());

    }
}
