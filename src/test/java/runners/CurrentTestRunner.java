package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "steps",
        features = "classpath:features",
        tags = "@Current",
        plugin = "json:target/cucumber-report/cucumber.json"
)
public class CurrentTestRunner extends AbstractTestNGCucumberTests {
}
