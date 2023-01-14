package api.login;

import api.manager.APIManager;
import io.restassured.response.Response;

public class Login {

    public static final String ENDPOINT = "auth/basic/login/";

    public Response login(final String username, final String password) {
        String body = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        APIManager manager = new APIManager();
        return manager.post(ENDPOINT, body);
    }

}
