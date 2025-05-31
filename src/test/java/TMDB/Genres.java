package TMDB;

import utility.ConfigReader;
import utility.Parent;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Genres extends Parent {
    @Test
    public void getMovieList() {
        int movieID=
        given()
                .spec(reqSpec)
                .when()
                .get("genre/movie/list")
                .then()
                .log().body()
                .statusCode(200)
                .extract().path("genres[0].id");
        String movieIDStr= String.valueOf(movieID);
        ConfigReader.updateProperty("movieID");
        ConfigReader.saveToConfig("movieID",movieIDStr);

        ;
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
