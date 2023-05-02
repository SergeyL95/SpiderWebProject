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
		tags="@resetPassword",
=======
		tags="@createCustomerValid",
>>>>>>> 6f2fe41706edba01bdf33206cdf222e6bc0cf464
		publish=true
		)

public class TestRunner {

}
