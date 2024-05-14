package StepDefinitions;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;

import com.aventstack.extentreports.util.Assert;

import TestRequest.LMSReqspec;
import TestRunner.UserTestRunner;
import Utilities.ConfigReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


public class UserLoginController {

	ConfigReader ConfigReaderobj;
	Properties prop;
	Response response;
	String reqBody;
	String token;
	JSONObject requestParams = new JSONObject();
	Object retrievedToken =UserTestRunner.scenarioContext.getContext("Token", token);
	Object invalidToken ="hjhjdsjhdjk";
	
	//ConfigReader for reading UserID and password from config file	
	public  UserLoginController() throws IOException {
		        ConfigReaderobj = new ConfigReader();
		        prop = ConfigReaderobj.init_prop();
		}
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
		
		String Email = prop.getProperty("username"); 
		String Password = prop.getProperty("Password"); 

	    requestParams.put("password", Password);
	    requestParams.put("userLoginEmailId", Email);
		    
		    
		    

	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {

		response = RestAssured
        		.given()
        		.spec(LMSReqspec.UserLogin()).body(requestParams.toJSONString())
        		.when().post();



	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {

	    token = response.jsonPath().getString("token");
	    Object gettoken = UserTestRunner.scenarioContext.setContext("Token", token);
        LoggerLoad.info("the response of the rquest is " + response);

		response.then().log().all().assertThat().statusCode(int1).extract().response().asString();
		/*int statuscode=response.getStatusCode();
		System.out.println("Statuscode:" +statuscode);*/

	}
	
	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() {

		response = RestAssured
        		.given()
        		.spec(LMSReqspec.UserLogin_invalidendpoint()).body(requestParams.toJSONString())
        		.when().post();

	        LoggerLoad.info("the response of the rquest is " + response);

	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer int1) {

		response.then().log().all().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
		System.out.println("Statuscode:" +statuscode);

	}
	
	@Given("Admin creates request with invalid credentials")
	public void admin_creates_request_with_invalid_credentials() {

		String Email = prop.getProperty("invalid_username"); 
		String Password = prop.getProperty("invalid_Password"); 

	    requestParams.put("password", Password);
	    requestParams.put("userLoginEmailId", Email); 

	}

	@Then("Admin receives {int} Bad request")
	public void admin_receives_bad_request(Integer int1) {

		response.then().log().all().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
		System.out.println("Statuscode:" +statuscode);

	}	
/*	@Given("Admin creates request")
	public void admin_creates_request() {

	}

	@When("Admin calls Get Https method with valid endpoint")
	public void admin_calls_get_https_method_with_valid_endpoint() {

		response = RestAssured
				.given().header("Authorization","Bearer "+retrievedToken)
	    		.spec(LMSReqspec.User_logout())
	    		.when()
		    	.get();

	}

	@Then("Admin receives {int} ok  and response with {string}")
	public void admin_receives_ok_and_response_with(Integer int1, String string) {

		response.then().log().all().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
		System.out.println("Statuscode:" +statuscode);

	}

	@When("Admin calls Get Https method withinvalid endpoint")
	public void admin_calls_get_https_method_withinvalid_endpoint() {

		response = RestAssured
				.given().header("Authorization","Bearer "+retrievedToken)
	    		.spec(LMSReqspec.User_logout_invalidendpoint())
	    		.when()
		    	.get();

	}

	@Then("Admin receives {int} Not found")
	public void admin_receives_not_found(Integer int1) {

		response.then().log().all();
	    response.then().statusCode(405);
	    response.then().header("Content-Type", "application/json");

	}

	@When("Admin calls Get Https method with valid endpoint with no auth")
	public void admin_calls_get_https_method_with_valid_endpoint_with_no_auth() {

		response = RestAssured
				.given().header("Authorization","Bearer "+invalidToken)
	    		.spec(LMSReqspec.User_logout())
	    		.when()
		    	.get();

	}
	
	@Then("Admin receives {int}  unauthorizedd")
	public void admin_receives_unauthorizedd(Integer int1) {

		response.then().log().all();
	    response.then().statusCode(401);
	    response.then().header("Content-Type", "application/json");

	}	*/
}
