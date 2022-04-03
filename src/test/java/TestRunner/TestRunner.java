package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Projects\\CucumberWithMaven\\src\\test\\java\\Features\\Feature.Feature",
glue={"stepDefination"} , monochrome = true , tags = {"@ExistingUser"} ,
plugin= {"pretty","html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json",
	"rerun:target/failed_scenarios.txt"}

)


public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
