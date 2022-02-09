package demoblaze.stepdefinitions;

import demoblaze.steps.ProductSteps;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

/**
 * Created by sekarayukarindra.
 */
public class ProductStepDefinitions {
    @Steps
    private ProductSteps productSteps;

    @And("user click on add to cart button")
    public void userClickOnAddToCartButton() {
        productSteps.clickAddToCartBtn();
    }

    @And("user navigate to {string} page")
    public void userNavigateToPage(String menu) {
        productSteps.navigateTo(menu);
    }
}
