package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features="./src/main/java/features/CreateNewWorkType.feature",
	    glue="stepdefinitions",
	    plugin= {"pretty","html:HTML-Reports"},
	    monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	


}
