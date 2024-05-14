package TestRunner;

import org.junit.runner.RunWith;



import Utilities.ScenarioContext;
//import Utilities.ScenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/UserAPI.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
						//tags = "@tag3-post",
						//tags = "@tag19 or @tag20 or @tag21 or @tag22 or @tag23",
						//tags = "@tag1m or @tag2m or @tag3m or @tag4m or @tag5m or @tag6m or @tag7m or @tag8m",
						tags = "",
				/*tags = "@tag1-getalluser or @tag2-getinvalidendpoint or @tag3-post or @tag4-getbyuserid or
						@tag5-getbyusername or @tag7-deletebyuserid"*/
				//tags="@tag3-post or @tag5-getbyusername",
				//features= {"src/test/resources/Feature"},
				features= {"src/test/resources/Feature/userlogout.feature"},						
				glue = {"StepDefinition"}
			
		)

public class UserTestRunner {
	public static ScenarioContext scenarioContext = new ScenarioContext();
}
