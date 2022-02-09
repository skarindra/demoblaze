package demoblaze.steps;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by sekarayukarindra.
 */
public class HomeSteps extends PageObject {
    private BaseSteps baseSteps = new BaseSteps();
    private String URL = "https://www.demoblaze.com/index.html";
    private Logger logger = LogManager.getLogger(HomeSteps.class);

    @FindBy(id = "nava")
    private WebElementFacade titleProductStore;

    @FindBy(linkText = "Phones")
    private WebElementFacade catPhone;

    @FindBy(linkText = "Laptops")
    private WebElementFacade catLaptop;

    @FindBy(linkText = "Monitors")
    private WebElementFacade catMonitor;

    @FindBy(partialLinkText = "Samsung")
    private WebElementFacade cardTitlePhone;

    @FindBy(partialLinkText = "Sony")
    private WebElementFacade cardTitleLaptop;

    @FindBy(partialLinkText = "monitor")
    private WebElementFacade cardTitleMonitor;

    @Step
    public void openPage(){
        openUrl(URL);
        baseSteps.assertElementPresent(titleProductStore);
    }

    @Step
    public void chooseCategory(String category){
        switch (category.toLowerCase()){
            case "phones" :
                clickOn(catPhone);
                //wait until phones are displayed
                waitFor(cardTitlePhone);
                break;
            case "laptops" :
                clickOn(catLaptop);
                //wait until laptops are displayed
                waitABit(5000);
                //waitFor(ExpectedConditions.visibilityOf(cardTitleLaptop));
                //waitFor(cardTitleLaptop);
                break;
            case "monitors" :
                clickOn(catMonitor);
                //wait until laptops are displayed
                waitFor(cardTitleMonitor);
                break;
        }
    }

    @Step
    public void verifyAndClickOnProduct(String prodName){
        ListOfWebElementFacades listOfWebElementFacades = findAll(By.className("card-title"));

        for(int i=0; i< listOfWebElementFacades.size(); i++){
            WebElementFacade elm = listOfWebElementFacades.get(i);
            String prod = elm.getText();
            if(prod.equals(prodName)){
                clickOn(elm);
                break;
            }
        }
    }

}
