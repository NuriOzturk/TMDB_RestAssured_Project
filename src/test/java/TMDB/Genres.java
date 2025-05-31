package TMDB;

import Utility.Parent;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Genres extends Parent {
    @Test
    public void getMovieList() {
        given()
                .spec(reqSpec)
                .when()
                .get("genre/movie/list")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getTVList(){
        given()
                .spec(reqSpec)
                .when()
                .get("genre/tv/list")
                .then()
                .log().body()
                .statusCode(200);
    }

}
