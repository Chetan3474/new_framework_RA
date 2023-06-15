package request_repository;

import java.io.IOException;






public class Put_Request_Repository {
	public static String Baseuri()
	{
		String baseuri="https://reqres.in/";
		return baseuri;
	}
	
	public static String resource()
	{
		String resource="api/users/2";
		return resource;
	}
	
	public static String Put_request_TC1() throws IOException
	{
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return requestBody;
	}
}
