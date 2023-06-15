package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.commonMethodUtilities;
import common_method.common_method_api;
import io.restassured.path.json.JsonPath;
import request_repository.Post_Request_Repository;

public class PostTc1 {
@Test

public static void orchestrator() throws IOException
{
String responseBody="";
int responseStatusCode=0;
String baseuri=Post_Request_Repository.Baseuri();
String resorce=Post_Request_Repository.resource();
String requestBody=Post_Request_Repository.Post_request_TC1();

for (int i=0;i<5;i++)
{
	responseStatusCode = common_method_api.responsestatuscode_extractor(baseuri, resorce, requestBody);
	
	if(responseStatusCode == 201)
	{
		responseBody=common_method_api.responsebody_extractor(baseuri, resorce, requestBody);
		responseBodyValidator(responseBody);
		break;
	}
	else
	{
		System.out.println("Correct status code is not found in the iteration" + i);
	}
	}
	commonMethodUtilities.evidenceFileCreator("PostTc1", requestBody, responseBody);
	Assert.assertEquals(responseStatusCode, 201);
}

public static void responseBodyValidator(String responseBpdy)
{
	// Create jsonPath object to extract responsebody parameters
JsonPath jsp= new JsonPath(responseBpdy);
//extract responsebody parameters
String res_name=jsp.getString("name");
String res_job=jsp.getString("job");
String res_id=jsp.getString("id");
String res_craetedAt=jsp.getString("createdAt");

//Validate responsebody parameters
Assert.assertEquals(res_name,"morpheus");
Assert.assertEquals(res_job,"leader");
Assert.assertNotEquals(res_id,"assertion error,id is null");

//extract date from createdAt parameter

String actual_date = res_craetedAt.substring(0,10);
String current_date = LocalDate.now().toString();
Assert.assertEquals(actual_date, current_date);

}
}









