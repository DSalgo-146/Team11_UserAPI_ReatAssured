package TestRequest;

import java.util.Properties;

import Utilities.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LMSReqspec {

	static RequestSpecBuilder req = new RequestSpecBuilder();
    static Properties prop;
	
	public static RequestSpecification UserLogin() {
	
		
		req.setBaseUri(Endpoint.BaseURL);
		RequestSpecification res = req.build();
		req.setBasePath(Endpoint.Post_Login);
		req.setContentType(ContentType.JSON);
	
		return res;
	}
public static RequestSpecification UserLogin_invalidendpoint() {
	
		
		req.setBaseUri(Endpoint.BaseURL);
		RequestSpecification res = req.build();
		req.setBasePath(Endpoint.Post_Login_invalidendpoint);
		req.setContentType(ContentType.JSON);
	
		return res;
	}
}
