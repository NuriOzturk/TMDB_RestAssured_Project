package tmdb;

import utility.ConfigReader;
import utility.Parent;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class _02_Genres extends Parent {
    @Test(priority = 1)
    public void getMovieList() {
        int movieID =
        given()
                .spec(reqSpec)
                .when()
                .get("genre/movie/list")
                .then()
                .log().body()
                .statusCode(200)
                .extract().path("genres[0].id");
        String movieIDStr = String.valueOf(movieID);
        ConfigReader.updateProperty("movieID");
        ConfigReader.saveToConfig("movieID", movieIDStr);
    }

    @Test(priority = 2)
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