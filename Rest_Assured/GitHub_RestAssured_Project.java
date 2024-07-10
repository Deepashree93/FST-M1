package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_RestAssured_Project {
	

    // Declare response specification
    
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILnASTYH36ZhJFNtWu6Rop0M+6vTlHpaaT8maVusgxSf";
    int sshKeyId ;
    
    	RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "token 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")
                .build();
    	
    	ResponseSpecification responseSpec = new ResponseSpecBuilder()
               // .expectStatusCode(200)
                //.expectHeader("Content-Type", "application/json; charset=utf-8")
    			.setDefaultParser(Parser.JSON)
                .expectBody("key", equalTo(sshKey))
                .expectBody("title", equalTo("TestAPIKey"))
                .build();
    
  @Test(priority = 1)
  public void postRequest() {
	  
	  Map<String, Object> reqBody = new HashMap<String,Object>();
	  reqBody.put("title", "TestAPIKey");
	  reqBody.put("key", sshKey);
	  
	  Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");
	  //Reporter.log(response.asPrettyString());
	  response.prettyPrint();
	  
	  sshKeyId = response.then().extract().path("id");
	  
	  
	  response.then().statusCode(201).spec(responseSpec);
  }
  
  @Test(priority = 2)
  public void getRequest() {
	  
	  given().spec(requestSpec).pathParam("keyId", sshKeyId).
	  when().get("/user/keys/{keyId}").
	  then().statusCode(200).spec(responseSpec);
	  
  }
  
  @Test(priority = 3)
  public void deleteRequest() {
	  
	  
	  given().spec(requestSpec).pathParam("keyId", sshKeyId).
	  when().delete("/user/keys/{keyId}").
	  then().spec(responseSpec).assertThat().statusCode(204).log().all();
	  
  }
}
