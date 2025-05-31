package tmdb;

import utility.Parent;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class _03_MovieList extends Parent {
    @Test(priority = 1)
    public void getNowPlaying() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/now_playing")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void getPopular() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/popular")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void getTopRated() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/top_rated")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void getUpcoming() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/upcoming")
                .then()
                .log().body()
                .statusCode(200);
    }
}