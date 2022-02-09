package demoblaze.steps;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by sekarayukarindra.
 */
public class ProductSteps extends PageObject {

    private Logger logger = LogManager.getLogger(HomeSteps.class);

    @FindBy(xpath = "//*[@class='btn btn-success btn-lg' and text()='Add to cart']")
    private WebElementFacade addToCartBtn;

    @FindBy(id = "nava")
    private WebElementFacade prodStoreTitle;

    @FindBy(linkText = "Cart")
    private WebElementFacade cartNavMenu;

    public void clickAddToCartBtn(){
        clickOn(addToCartBtn);
        waitABit(5000);
        try {
            getAlert().accept();
        }catch(NoAlertPresentException e){
            logger.info("alert not present!");
        }
    }

    public void navigateTo(String menu){
        switch (menu.toLowerCase()){
            case "home" :
                waitFor(ExpectedConditions.elementToBeClickable(prodStoreTitle));
                clickOn(prodStoreTitle);
                break;
            case "cart" :
                waitFor(ExpectedConditions.elementToBeClickable(cartNavMenu));
                clickOn(cartNavMenu);
                break;
        }
    }
}
