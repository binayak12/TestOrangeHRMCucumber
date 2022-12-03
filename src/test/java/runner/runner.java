package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/1-login.feature"
                ,"src/test/resources/features/PIM/2-AddEmployee.feature"}

        ,glue =  {"stepDefinations", "stepDefinations.PIM"}
        ,dryRun = false
)
public class runner {
}
