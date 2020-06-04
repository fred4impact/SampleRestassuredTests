package sampleTests;


import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SampleRest1 {


    @Test(enabled = false)
    public void getAllUsers(){

        // using local server
        baseURI = "http://localhost:3000";
        given()
           .headers("Content-Type", "applieation/json")
            .param("name", "Java")
           .get("/subjects")
        .then()
        .statusCode(200)
        .log().all();

    }

    @Test(enabled = false)
    public void postRecord(){

        // used json object to send/ create new records in the database
        JSONObject sendRecord = new JSONObject();
        sendRecord.put("firstname", "Dandy");
        sendRecord.put("lastname", "Brown");
        sendRecord.put("subjectId", 1);

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


    @Test(enabled = false)
    public void patchRecord(){

        // used json object to send/ create new records in the database
        JSONObject sendRecord = new JSONObject();

        // sending a patch record to change the first name
        sendRecord.put("firstname", "wilson");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .header("content-Type", "application/json")
                .body(sendRecord.toJSONString())
                .when()
                .patch("/users/4")
//                .post("/users")
                .then()
                .statusCode(200)// success code
                .log().all();

    }

    @Test(enabled = false)
    public void putRecord(){

        // used json object to send/ create new records in the database
        JSONObject sendRecord = new JSONObject();

        // sending a put record to change the first name
        sendRecord.put("firstname", "James");
        sendRecord.put("lastname", "Crown");
        sendRecord.put("subjectId", 2);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .header("content-Type", "application/json")
                .body(sendRecord.toJSONString())
                .when()
                .put("/users/4")
//                .post("/users")
                .then()
                .statusCode(200)// success code
                .log().all();

    }

    @Test
    public void test_deleteRecord(){
        // url of the AUT applicastion

        baseURI = "http://localhost:3000";
        given()
            .when().delete("/users/4")
            .then()
                .statusCode(200)
                .log().all();

    }




}
