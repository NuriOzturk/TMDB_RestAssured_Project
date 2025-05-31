package TMDB;

import utility.ConfigReader;
import utility.Parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Movies extends Parent {
    @Test
    public void getDetails() {

        given()
                .spec(reqSpec)
                .when()
                .get("/movie/" + ConfigReader.getProperty("movieID"))
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getLists() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/" + ConfigReader.getProperty("movieID") + "/lists")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
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
}
