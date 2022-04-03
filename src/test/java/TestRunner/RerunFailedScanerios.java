package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/failed_scenarios.txt"},
glue={"stepDefination"} , monochrome = true , tags = {"@NewUserCreation_UpdatedData , @NewUserCreation , @ExistingUser"} ,
plugin= {"pretty","html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json","rerun:target/failed_scenarios.txt"}
)


public class RerunFailedScanerios  extends AbstractTestNGCucumberTests{
	
	

}
