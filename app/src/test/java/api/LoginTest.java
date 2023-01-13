package api;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LoginTest {

    private final static String LOGIN = "{\"username\":\"rodrigo.bernal\",\"password\":\"apitesting\"}";

    @Test
    public void testStatusCode() {

        baseURI = "https://test-api.k6.io";

        given().log().all()
                .contentType(ContentType.JSON)
                .body(LOGIN)
                .post("/auth/basic/login/")
        .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testResponseBody() {

        baseURI = "https://test-api.k6.io";

        given().log().all()
                .contentType(ContentType.JSON)
                .body(LOGIN)
                .post("/auth/basic/login/")
        .then().log().all()
                .assertThat()
                .body("id", Matchers.equalTo(664426))
                .body("username", Matchers.equalTo("rodrigo.bernal"))
                .body("first_name", Matchers.equalTo("Rodrigo"))
                .body("last_name", Matchers.equalTo("Bernal"))
                .body("email", Matchers.equalTo("rodrigo.bernal@jala.university"))
                .body("date_joined", Matchers.equalTo("2022-12-21T15:02:16.417500Z"));
    }
}
