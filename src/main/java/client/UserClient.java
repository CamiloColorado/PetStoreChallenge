package client;

import data.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilities.EnvironmentReader.getUrl;

public class UserClient {

    public Response createUser(User user) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).body(user).post(Endpoints.USER);
    }

    public Response getLogin(String username, String password) {
        return given().baseUri(getUrl()).queryParam("username", username).queryParam("password", password).get(Endpoints.USER_LOGIN);
    }

    public Response getLogout() {
        return given().baseUri(getUrl()).get(Endpoints.USER_LOGOUT);
    }

    public Response getUser(String username) {
        return given().baseUri(getUrl()).pathParam("username", username).get(Endpoints.USER_BY_NAME);
    }

    public Response updateUser(String username, User user) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).pathParam("username", username).body(user).put(Endpoints.USER_BY_NAME);
    }

    public Response deleteUser(String username) {
        return given().baseUri(getUrl()).pathParam("username", username).delete(Endpoints.USER_BY_NAME);
    }

    public Response createListOfUsers(List<User> userList) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).body(userList).post(Endpoints.USER_LIST);
    }
}
