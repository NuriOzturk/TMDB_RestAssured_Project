package tmdb;

import utility.ReusableMethods;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class _04_Search extends ReusableMethods {
    @Test(priority = 1)
    public void getMovie() {
        given()
                .spec(reqSpec)
                .queryParam("query", "Hot Frosty")
                .when()
                .get("/search/movie")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void getTV() {
        given()
                .spec(reqSpec)
                .queryParam("query", "Watch What Happens Live with Andy Cohen")
                .when()
                .get("/search/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void getPerson() {
        given()
                .spec(reqSpec)
                .queryParam("query", "Jason Statham")
                .when()
                .get("/search/person")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void geKeyword() {
        given()
                .spec(reqSpec)
                .queryParam("query", "TV")
                .when()
                .get("/search/keyword")
                .then()
                .log().body()
                .statusCode(200);
    }
}