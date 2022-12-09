package runner.PIM;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"
                ,"src/test/resources/features/PIM"}
        ,glue = {"stepDefinations", "stDefinaeptions.PIM"}
        ,dryRun = false
        ,tags = "@smoke"
)
public class addEmployee_Smoke {
}
