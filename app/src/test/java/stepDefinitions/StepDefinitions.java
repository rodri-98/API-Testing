package StepDefinitions;

import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;

import api.login.Login;
import api.properties.ConfigProp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StepDefinitions {

    Response response;


    @Given("The user has a valid account")
    public void validAccount() {
        System.out.println("The user has a valid account");
    }

    @When("The user login into the page")
    public void loginIntoThePage() {
        Login login = new Login();
        ConfigProp config = ConfigFactory.create(ConfigProp.class);
        response = login.login(config.username(), config.password());
    }

    @Then("The user session is opened")
    public void sessionOpened() {
        Assert.assertEquals(664426, response.jsonPath().getInt("id"));
        Assert.assertEquals("rodrigo.bernal", response.jsonPath().getString("username"));
        Assert.assertEquals("Rodrigo", response.jsonPath().getString("first_name"));
        Assert.assertEquals("Bernal", response.jsonPath().getString("last_name"));
        Assert.assertEquals("rodrigo.bernal@jala.university", response.jsonPath().getString("email"));
        Assert.assertEquals("2022-12-21T15:02:16.417500Z", response.jsonPath().getString("date_joined"));
    }

    @And("A Status Code OK is displayed")
    public void statusCodeOk() {
        Assert.assertEquals(200, response.getStatusCode());
    }

}
