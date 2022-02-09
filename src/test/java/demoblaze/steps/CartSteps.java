package demoblaze.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by sekarayukarindra.
 */
public class CartSteps extends PageObject {

    private BaseSteps baseSteps = new BaseSteps();
    private Logger logger = LogManager.getLogger(CartSteps.class);
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @FindBy(id = "totalp")
    private WebElementFacade totalPrice;

    @FindBy(xpath = "//*[@class='btn btn-success' and text()='Place Order']")
    private WebElementFacade placeOrderBtn;

    @FindBy(id = "name")
    private WebElementFacade name;

    @FindBy(id = "country")
    private WebElementFacade country;

    @FindBy(id = "city")
    private WebElementFacade city;

    @FindBy(id = "card")
    private WebElementFacade card;

    @FindBy(id = "month")
    private WebElementFacade month;

    @FindBy(id = "year")
    private WebElementFacade year;

    @FindBy(xpath = "//*[@class='btn btn-primary' and text()='Purchase']")
    private WebElementFacade purchaseBtn;

    @FindBy(xpath = "/html/body/div[10]/h2")
    private WebElementFacade purchaseOkConfirmation;

    @FindBy(xpath = "/html/body/div[10]/p")
    private WebElementFacade orderConfirmation;

    @FindBy(xpath = "//*[@class='confirm btn btn-lg btn-primary']")
    private WebElementFacade btnOK;

    @Step
    public void verifyProductAdded(String products){
        List<String> listProd = findAll(By.xpath("//*[@id='tbodyid']/*/td[2]")).texts();
        String[] prod = products.split(",");
        for(int i=0; i<prod.length; i++){
            logger.info("prod : "+prod[i].trim());
            assert listProd.contains(prod[i].trim());
        }
        setPrice(totalPrice.getText());
    }

    @Step
    public void custPlaceOrder(DataTable details){
        clickOn(placeOrderBtn);
        waitFor(name);

        List<List<String>> data = details.asLists();
        typeInto(name, data.get(1).get(0));
        typeInto(country, data.get(1).get(1));
        typeInto(city, data.get(1).get(2));
        typeInto(card, data.get(1).get(3));
        typeInto(month, data.get(1).get(4));
        typeInto(year, data.get(1).get(5));

        clickOn(purchaseBtn);
    }

    @Step
    public void verifyPurchaseSuccess(){
        waitFor(ExpectedConditions.visibilityOf(purchaseOkConfirmation));
        assert purchaseOkConfirmation.getText().equalsIgnoreCase("Thank you for your purchase!");

        String orderConfirmText = orderConfirmation.getText();
        String[] order = orderConfirmText.split("\n");

        logger.info("Purchase "+order[0]);
        logger.info("Purchase "+order[1]);

        assert order[1].replaceAll("[\\D]","").equals(getPrice());
        clickOn(btnOK);
    }




}
