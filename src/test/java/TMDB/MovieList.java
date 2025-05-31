package TMDB;

import Utility.Parent;
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
}
