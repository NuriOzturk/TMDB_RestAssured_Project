package tmdb;

import utility.Parent;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Search extends Parent {
    @Test
    public void getMovie(){
        given()
                .spec(reqSpec)
                .queryParam( "query", "Hot Frosty")
                .when()
                .get("/search/movie")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getTV(){
        given()
                .spec(reqSpec)
                .queryParam( "query", "Watch What Happens Live with Andy Cohen")
                .when()
                .get("/search/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public  void getPerson(){
        given()
                .spec(reqSpec)
                .queryParam( "query", "Jason Statham")
                .when()
                .get("/search/person")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getkeyword(){
        given()
                .spec(reqSpec)
                .queryParam( "query", "TV")
                .when()
                .get("/search/keyword")
                .then()
                .log().body()
                .statusCode(200);
    }





}
