package demoblaze.stepdefinitions;

import demoblaze.steps.HomeSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by sekarayukarindra.
 */
public class HomeStepDefinitions {

    @Steps
    private HomeSteps homeSteps;

    @Given("^user wants to open page$")
    public void userWantsToOpenPage() {
        homeSteps.openPage();
    }

    @When("user choose category {string}")
    public void userChooseCategory(String cat) {
        homeSteps.chooseCategory(cat);
    }

    @And("user see and click on product {string}")
    public void userSeeAndClickOnProduct(String prodName) {
        homeSteps.verifyAndClickOnProduct(prodName);
    }
}
