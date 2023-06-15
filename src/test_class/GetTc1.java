package test_class;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.commonMethodUtilities;
import common_method.common_method_get_api;
import io.restassured.path.json.JsonPath;
import request_repository.Get_Request_Repository;

public class GetTc1 {

@Test
public static void orchestrator() throws IOException
{
String responseBody="";
int responseStatusCode=0;
String baseuri=Get_Request_Repository.Baseuri();
String resource=Get_Request_Repository.resource();


for (int i=0;i<5;i++)
{
	responseStatusCode = common_method_get_api.responsestatuscode_extractor(baseuri, resource);
	if(responseStatusCode == 200)
	{
		responseBody=common_method_get_api.responsebody_extractor(baseuri, resource);
		responseBodyValidator(responseBody);
		break;
	}
	else
	{
		System.out.println("Correct status code is not found in the iteration" + i);
	}
	}
	commonMethodUtilities.evidenceFileCreator("GetTc1",null, responseBody);
	Assert.assertEquals(responseStatusCode, 200);
}

public static void responseBodyValidator(String responseBpdy)
{
	// Create jsonPath object to extract responsebody parameters
JsonPath jsp= new JsonPath(responseBpdy);
int count = jsp.getInt("data.size()");
System.out.println("length of array" + count);
int id[] = {7,8,9,10,11,12};
String email[] = {"michael.lawson@reqres.in","lindsay.ferguson@reqres.in","tobias.funke@reqres.in","byron.fields@reqres.in","george.edwards@reqres.in","rachel.howell@reqres.in"};
String first_name[] = {"Michael","Lindsay","Tobias","Byron","George","Rachel"};
String last_name[] = {"Lawson","Ferguson","Funke","Fields","Edwards","Howell"};
String avatar[] = {"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg","https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg","https://reqres.in/img/faces/11-image.jpg","https://reqres.in/img/faces/12-image.jpg"};
for (int i=0;i<count;i++)
{
	int exp_id = id[i];
	String exp_email = email[i];
	String exp_fname = first_name[i];
	String exp_lname = last_name[i];
	String exp_avatar = avatar[i];
	
//extract responsebody parameters
	int res_id = jsp.getInt("data["+ i +"].id");
	String res_email = jsp.getString("data["+ i +"].email");
	String res_fname = jsp.getString("data["+ i +"].first_name");
	String res_lname = jsp.getString("data["+ i +"].last_name");
	String res_avatar = jsp.getString("data["+ i +"].avatar");
	
//Validate responsebody parameters

	Assert.assertEquals(res_id, exp_id);
	Assert.assertEquals(res_email, exp_email);
	Assert.assertEquals(res_fname, exp_fname);
	Assert.assertEquals(res_lname, exp_lname);
	Assert.assertEquals(res_avatar, exp_avatar);

}
}
}








