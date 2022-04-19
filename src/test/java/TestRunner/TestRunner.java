package TestRunner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = "src/test/java/Features", glue = {"StepDefination"}, monochrome = true, 
plugin = { "pretty","html:target/Cucumber.html", "json:target/cucumber/cucumber.json" })

	

public class TestRunner extends AbstractTestNGCucumberTests {
 
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
    
}
	
