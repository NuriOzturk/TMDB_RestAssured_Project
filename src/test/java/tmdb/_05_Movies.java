package tmdb;

import utility.ConfigReader;
import utility.Parent;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class _05_Movies extends Parent {
    @Test(priority = 1)
    public void getDetails() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/" + ConfigReader.getProperty("movieID"))
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void getLists() {
        int listID = given()
                .spec(reqSpec)
                .when()
                .get("/movie/" + ConfigReader.getProperty("movieID") + "/lists")
                .then()
                .log().body()
                .extract().path("results[0].id");
        String listIDStr = String.valueOf(listID);
        ConfigReader.updateProperty("listID");
        ConfigReader.saveToConfig("listID", listIDStr);
        System.out.println("listID = " + listID);
    }

    @Test(priority = 3)
    public void postAddRating() {
        Map<String, String> addRating = new HashMap<>();
        addRating.put("value", "7.0");
        given()
                .spec(reqSpec)
                .body(addRating)
                .when()
                .post("/movie/" + ConfigReader.getProperty("movieID") + "/rating")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test(priority = 4)
    public void deleteRating(){
        given()
                .spec(reqSpec)
                .when()
                .delete("/movie/" + ConfigReader.getProperty("movieID") + "/rating")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void postAddMovie(){
        given()
                .spec(reqSpec)
                .queryParam("session_id",ConfigReader.getProperty("accountID"))
                .body("{\"media_id\": " + ConfigReader.getProperty("movieID") + "}")
                .when()
                .post("/list/" + ConfigReader.getProperty("listID") + "/add_item")
                .then()
                .log().body()
                .statusCode(401); // Method Not Allowed, as we cannot add a movie without proper body and authentication
    }
}