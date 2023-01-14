package api.manager;

import org.aeonbits.owner.ConfigFactory;
import api.properties.ConfigProp;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIManager {

    public APIManager() {
        ConfigProp config = ConfigFactory.create(ConfigProp.class);
        RestAssured.baseURI = config.url();
    }

    public Response post(final String endpoint, final String body) {
        return RestAssured.given().contentType(ContentType.JSON).body(body).post(endpoint);
    }


}
