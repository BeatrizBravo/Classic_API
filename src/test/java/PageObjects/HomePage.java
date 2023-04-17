package PageObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class HomePage {

    public String getHomePage() {

        // 2. Send an HTTP GET request to /index.php and extract the response
        Response response =
                given()
                .when()
                .get("/index.php")
                .then()
                    .contentType(ContentType.HTML)//ValidatableResponseOptions methods.
                    .assertThat()
                    .statusCode(200)
                        // 3. Create an assertion using .body() to compare the text inside of a tag
                    .body("html.head.title", equalTo("Ten10 Store"))
                        .log().all()
                    .extract().response()
                            ;

        return "We are in the home page";


//        String contentType = response.getContentType();
//        System.out.println("Content-Type of response is : "+contentType);

    }

    public String testStatusCode400(){


//2.SendanHTTPGETrequestto/index.phpandextracttheresponse
        Response response=
                given()
                        .when()
                        .get("/jfjufhdgb%20gvdm")
                        .then()
                        .contentType(ContentType.HTML)
                        .assertThat()
                        .statusCode(404)
                        .extract().response();

        return "StatusCodewas404";

    }
}
