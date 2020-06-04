package Testcases;


import Utilities.RestUtils;
import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import net.minidev.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TC003_Post_Record extends TestBase {

    // Here we instantiate and use the random utility class
    String employeeName= RestUtils.empName();
    String salary=RestUtils.Salary();
    String age = RestUtils.empAge();


    @BeforeClass
    public void createRecords() throws InterruptedException
    {


        //logger.info("Step 1 : ----- Stage the BaseUrl -------");
        System.out.println("------ Start Application -------");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        /*
          here we create a JSONOBject
          class for the data we will be using
         */

        //  create a json object parameter to send
        JSONObject sendParams = new JSONObject();
        sendParams.put("name", employeeName);
        sendParams.put("salary", salary);
        sendParams.put("age", age);

        // here we adding a header stating the body request.
        httpRequest.headers("Content-Type", "application/json");
        // adding json to the body
        httpRequest.body(sendParams.toJSONString());
        // get response
        response = httpRequest.request(Method.POST, "/create");

        // delay time of post
        Thread.sleep(8000);
       //logger.info(" Create Record request" + response);
    }

    @Test()
    public void verifyResponseBody(){


        String bodyResponse = response.getBody().asString();
        Assert.assertTrue(bodyResponse.contains(employeeName));
        Assert.assertTrue(bodyResponse.contains(salary));
        Assert.assertTrue(bodyResponse.contains(age));


    }


    @Test
    public void verifyStatusCode(){
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode, 200);
        System.out.println("Response status code is :" + statusCode);
    }

    @Test
    public void verifyStatusLine(){
        String contentLine = response.getStatusLine();
        System.out.println( "Actual Content line " +contentLine );
        Assert.assertEquals(contentLine,"HTTP/1.1 200 OK");


    }

    @Test
    public void verifyContentType(){
       String contentType = response.header("Content-Type");
       Assert.assertEquals(contentType, "text/html; charset=UTF-8");
    }


    @Test
    public void verifyServerType(){
        String server = response.header("Server");
        Assert.assertEquals(server, "nginx/1.16.0");
    }


    @Test
    public void verifyContentEncoding(){
        String encoding = response.header("Content-Encoding");
        Assert.assertEquals(encoding, "gzip"); // gzip



    }



    @AfterClass
    public void tearDown(){
      //logger.info(" -------- End of Record Test --------");
        //System.out.println("------ End API TEST -----");
    }





}
