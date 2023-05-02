package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ={"pretty", 
				"html:test_results/cucumber_report.html",
				"json:test_results/cucumber_report.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
<<<<<<< HEAD
		tags="@basicInfoValidation",
=======
		tags="@resetPassword",
>>>>>>> b4249ff1c9d24bae310109f20f4e73be190a5d33
		publish=true
		)

public class TestRunner {

}
