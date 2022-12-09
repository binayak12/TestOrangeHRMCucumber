package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}
        ,glue =  {"stepDefinations"}
        ,dryRun = false
        ,tags = "@smoke"
)
public class Login_Smoke {
}
