package tmdb;

import utility.Parent;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MovieList extends Parent {
    @Test
    public void getNowPlaying() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/now_playing")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getPopular() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/popular")
                .then()
                .log().body()
                .statusCode(200);
    }


    @Test
    public void getTopRated() {
        given()
                .spec(reqSpec)
                .when()
                .get("/movie/top_rated")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
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
