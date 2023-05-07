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
<<<<<<< HEAD
<<<<<<< HEAD
		tags="@login",
=======
		tags="@validCreateItem",
>>>>>>> 899665560319d64df749cbc5bcf5fff7dee2f6fc
=======
		tags="@validCreateItem",
>>>>>>> main
=======
		tags="@validCreateItem",
>>>>>>> main
		publish=true
		)

public class TestRunner {

}
