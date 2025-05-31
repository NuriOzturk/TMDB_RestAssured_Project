package tmdb;

import utility.Parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Account extends Parent {

    @Test
    public void getAccountDetails() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void addToFavourites() {
        Map<String, String> addToFav = new HashMap<>();
        addToFav.put("media_type", "movie");
        addToFav.put("media_id", "548");
        addToFav.put("favorite", "true");

        given()
                .spec(reqSpec)
                .body(addToFav)
                .when()
                .post("/account/" + accountID + "/favorite")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void addToWatchlist() {
        Map<String, String> addToWatchlist = new HashMap<>();
        addToWatchlist.put("media_type", "movie");
        addToWatchlist.put("media_id", "11");
        addToWatchlist.put("watchlist", "true");

        given()
                .spec(reqSpec)
                .body(addToWatchlist)
                .when()
                .post("/account/" + accountID + "/watchlist")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void getFavouriteMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/favorite/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getFavoriteTV() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/favorite/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getRatedMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/rated/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getReatedTV() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/rated/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getWatchlistMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/watchlist/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getWatchlistTV() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/watchlist/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

}