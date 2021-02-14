package runner;

import io.cucumber.testng.CucumberOptions;
import projectspecificmethods.BaseClass;

@CucumberOptions(
		features= {"./src/test/java/features/Assessment1.feature"},
		glue="pages",
		monochrome=true
		)
public class TestRunner1 extends BaseClass{

}
