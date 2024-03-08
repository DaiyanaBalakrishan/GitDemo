package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber cannot run automatically it will runners {TestNG,junit}

@CucumberOptions(features="src/test/java/cucumber",glue="cucumberclass.stepDefinitions",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
