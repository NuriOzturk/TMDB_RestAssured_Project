package tmdb;

import utility.Parent;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class _01_Account extends Parent {
    @Test(priority = 1)
    public void getAccountDetails() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void postAddToFavourites() {
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

    @Test(priority = 3)
    public void postAddToWatchlist() {
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

    @Test(priority = 4)
    public void getFavouriteMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/favorite/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void getFavoriteTV() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/favorite/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void getRatedMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/rated/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void getReatedTV() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/rated/tv")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 8)
    public void getWatchlistMovies() {
        given()
                .spec(reqSpec)
                .when()
                .get("/account/" + accountID + "/watchlist/movies")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(priority = 9)
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