package testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import testBase.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/java/features",    // pest the path of Features file
		glue={"stepDefinitions","hooks","testBase","pages"}	,			// path of StepDefinitions
	plugin= {"pretty", "html:test-output/report.html"}                                        
		)


public class TestRunnerWith_Junit 
{
	@AfterClass
	public static void closeBrowser()
	{
		TestBase.teardown();
	}
}