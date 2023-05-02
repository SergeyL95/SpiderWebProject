package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/features",
		glue="step_definitions",
<<<<<<< HEAD
		tags="@VerifyUIComponentsOnItemsPage",
=======
		tags="@basicInfoValidation",
>>>>>>> a427c00cd20cb15fc295eb836342ac40ebd0b25d
		dryRun=true
		)
public class DryRunner {

}
