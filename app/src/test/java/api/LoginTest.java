package api;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LoginTest {

    @Test
    public void testLoginUser() {

        baseURI = "https://test-api.k6.io";

        String login = "{\"username\":\"rodrigo.bernal\",\"password\":\"apitesting\"}";

        given().log().all()
                .contentType(ContentType.JSON)
                .body(login)
                .post("/auth/basic/login/")
        .then().log().ifError()
                .assertThat()
                .statusCode(200)
                .body("id", Matchers.equalTo(664426))
                .body("username", Matchers.equalTo("rodrigo.bernal"))
                .body("first_name", Matchers.equalTo("Rodrigo"))
                .body("last_name", Matchers.equalTo("Bernal"))
                .body("email", Matchers.equalTo("rodrigo.bernal@jala.university"))
                .body("date_joined", Matchers.equalTo("2022-12-21T15:02:16.417500Z"));
    }
}
