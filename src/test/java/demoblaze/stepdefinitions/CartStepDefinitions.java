package demoblaze.stepdefinitions;

import demoblaze.steps.CartSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Created by sekarayukarindra.
 */
public class CartStepDefinitions {
    @Steps
    CartSteps cartSteps;

    @And("user verify cart contains {string}")
    public void userVerifyCartContains(String products) {
        cartSteps.verifyProductAdded(products);
    }

    @And("^user place the order with data:$")
    public void userPlaceTheOrderWithData(DataTable orderDetail) {
        cartSteps.custPlaceOrder(orderDetail);
    }

    @Then("purchase done successfully")
    public void purchaseDoneSuccessfully() {
        cartSteps.verifyPurchaseSuccess();
    }
}
