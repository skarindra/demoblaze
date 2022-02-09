package demoblaze;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by sekarayukarindra.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features={"classpath:features"},
        plugin = {"pretty"}
)
public class CucumberTestRunner {
}
