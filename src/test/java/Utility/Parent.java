package Utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class Parent {
    public RequestSpecification reqSpec;
    public int accountID = ConfigReader.getIntProperty("accountID");

    @BeforeClass
    public void setUp() {
        baseURI = "https://api.themoviedb.org/3/";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + ConfigReader.getProperty("token"))
                .build();
    }
}