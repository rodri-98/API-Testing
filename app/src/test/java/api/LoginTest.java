package api;

import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.junit.Test;

import api.login.Login;
import api.properties.ConfigProp;
import io.restassured.response.Response;


public class LoginTest {

    private final ConfigProp config = ConfigFactory.create(ConfigProp.class);

    @Test
    public void testStatusCode() {
        Login login = new Login();
        Response response = login.login(config.username(), config.password());
        Assert.assertEquals(200, response.getStatusCode());

    }

    @Test
    public void testResponseBody() {
        Login login = new Login();
        Response response = login.login(config.username(), config.password());
        Assert.assertEquals(664426, response.jsonPath().getInt("id"));
        Assert.assertEquals("rodrigo.bernal", response.jsonPath().getString("username"));
        Assert.assertEquals("Rodrigo", response.jsonPath().getString("first_name"));
        Assert.assertEquals("Bernal", response.jsonPath().getString("last_name"));
        Assert.assertEquals("rodrigo.bernal@jala.university", response.jsonPath().getString("email"));
        Assert.assertEquals("2022-12-21T15:02:16.417500Z", response.jsonPath().getString("date_joined"));
    }
}
