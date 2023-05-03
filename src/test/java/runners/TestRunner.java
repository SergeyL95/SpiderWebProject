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
		tags="@Regression",
		dryRun=false,
=======

		tags="@basicInfoValidation",

>>>>>>> a427c00cd20cb15fc295eb836342ac40ebd0b25d
		publish=true
		)

public class TestRunner {

}
