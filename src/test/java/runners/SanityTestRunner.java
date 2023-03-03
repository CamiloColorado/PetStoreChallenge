package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "steps",
        features = "classpath:features",
        tags = "@Sanity",
        plugin = "json:target/cucumber-report/cucumber.json"
)
public class SanityTestRunner extends AbstractTestNGCucumberTests {
}
