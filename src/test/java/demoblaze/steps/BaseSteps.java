package demoblaze.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by sekarayukarindra.
 */
public class BaseSteps {

    public void clickElement(WebElementFacade elementFacade){
        elementFacade.click();
    }

    public void inputValue(WebElementFacade elementFacade, String value){
        elementFacade.type(value);
    }

    public boolean isElementPresent(WebElementFacade elementFacade){
        return elementFacade.isDisplayed() && elementFacade.isCurrentlyVisible();
    }

    public void waitForVisibility(WebDriver driver, int timeout, WebElementFacade elementFacade){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(elementFacade));
        Assert.assertTrue(isElementPresent(elementFacade));
    }

    public void selectByValue(WebElementFacade elementFacade, String value){
        Select select = new Select(elementFacade);
        select.selectByValue(value);
    }

    public void selectByVisibleText(WebElementFacade elementFacade, String value){
        Select select = new Select(elementFacade);
        select.selectByVisibleText(value);
    }

    public void assertElementPresent(WebElementFacade elementFacade){
        Assert.assertTrue(isElementPresent(elementFacade));
    }
}
