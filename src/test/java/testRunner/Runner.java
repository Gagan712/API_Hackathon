package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import org.testng.annotations.DataProvider;

//import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features ={"src/test/resources/Features"},
		glue="stepDefinition",
		dryRun =false,
		monochrome = false,
        plugin= {"pretty","html:target/API.html"}
		
		)

public class Runner {
	
}

