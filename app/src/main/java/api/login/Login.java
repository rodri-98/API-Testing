package api.login;

import com.google.gson.Gson;

import api.entity.User;
import api.manager.APIManager;
import io.restassured.response.Response;

public class Login {

    public static final String ENDPOINT = "auth/basic/login/";

    public Response login(final String username, final String password) {
        User user = User.builder().username(username)
                .password(password).build();
        Gson gson = new Gson();
        String body = gson.toJson(user);
        APIManager manager = new APIManager();
        return manager.post(ENDPOINT, body);
    }

}
