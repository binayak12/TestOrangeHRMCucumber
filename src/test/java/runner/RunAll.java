package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"
        ,"src/test/resources/features/PIM"}
        ,glue = {"stepDefinations", "stepDefinations.PIM"}
        ,dryRun = false
)
public class RunAll {
}
