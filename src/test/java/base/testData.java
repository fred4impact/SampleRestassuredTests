package base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class testData {



/*
 this example is to help create dynamic data for our test
 and also read from excell

 Using TestNG dataProvider to get data to the method from the excell
 */

    @DataProvider(name = "PostData")
    public Object[][] dataForTest(){

         /*
            you can use another style to fecth from the array
            without specifiyig array numbers

        */

        return new Object[][] {
            // set data
                {"Bravo", "Chile", 2},
                {"Peter", "Tobby", 3},
                {"Warren", "Buffet", 1}
        };


        // here we specify the row num and colum number
//        Object[][] exceldata = new Object[3][3];
//
//           // this is te first mathod of doing this
//             // Row 1
//               exceldata[0][0] = "larry";
//               exceldata[0][1] = "King";
//               exceldata[0][2] = 3;
//
//               // Row 2
//                exceldata[1][0] = "Bud";
//                exceldata[1][1] = "Coggz";
//                exceldata[1][2] = 1;
//
//                // Row 3
//                exceldata[2][0] = "Wise";
//                exceldata[2][1] = "Men";
//                exceldata[2][2] = 2;
//
//        return exceldata; // return the data to the object
//
    }


    @Test(dataProvider = "PostData")
    public void PostRecord(String firstname, String lastname, int subjectId){

        // used json object to send/ create new records in the database
        JSONObject sendRecord = new JSONObject();
        sendRecord.put("firstname", firstname);
        sendRecord.put("lastname", lastname);
        sendRecord.put("subjectId", subjectId);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .header("content-Type", "application/json")
                .body(sendRecord.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();

    }

    public void verifyStatusCode(){

    }
}
