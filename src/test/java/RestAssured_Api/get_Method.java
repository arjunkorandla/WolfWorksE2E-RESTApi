package RestAssured_Api;
	import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
	import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import ww_salesrep.ww_salesrep.BaseClass;

	public class get_Method {
		public static RequestSpecification htprequest;
		public static Response response;

		@BeforeClass
		public void GetAllEmp() throws InterruptedException
		{
			
			RestAssured.baseURI="https://app.adm.workwolf.com/company/shareable-links/CAN/seangio";
			htprequest= RestAssured.given();
			response = htprequest.request(Method.GET);
			
			Thread.sleep(3000);
		}
		
		@Test
		public void statuscode()
		{
			
			int statuscode = response.getStatusCode();
			System.out.println(statuscode);
			Assert.assertEquals(statuscode,200 );
		}
		@Test
		public void statusline()
		{
			String statusline = response.getStatusLine();
			System.out.println(statusline);
			Assert.assertEquals(statusline.contains("HTTP/1.1 200"),true);
		}
		

		@Test
		public void body()
		{
			String body = response.getBody().asString();
			
			
			System.out.println(body);
			Assert.assertEquals(body.contains("Silver"),true);
			
		}
		
		@Test
		public void jsonPath()
		{
			JsonPath jp = response.jsonPath();
			//System.out.println(jp.get("id"));
			//System.out.println(jp.get("employee_name"));
			//System.out.println(jp.get("employee_age"));
		}
		
	}



