package steps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserSteps extends BaseSteps {

    @When("I create the new user")
    public void callCreateUserAPI() {
        User user = (User) dataStorage.getData("USER");
        Response response = userClient.createUser(user);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I create a list of users")
    public void callCreateListOfUsers() {
        List<User> userList = new ArrayList<>();
        userList.add((User) dataStorage.getData("USER"));
        userList.add(dataProvider.generateUser());
        Response response = userClient.createListOfUsers(userList);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I login into the system with the new user")
    public void callLoginAPI() {
        User user = (User) dataStorage.getData("USER");
        Response response = userClient.getLogin(user.getUsername(), user.getPassword());
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I logout from the system with the new user")
    public void callLogoutAPI() {
        Response response = userClient.getLogout();
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I look for the new user by username")
    public void callGetUserAPI() {
        User user = (User) dataStorage.getData("USER");
        Response response = userClient.getUser(user.getUsername());
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I update the user by the username")
    public void callUpdateUserAPI() {
        User user = (User) dataStorage.getData("USER");
        Response response = userClient.updateUser(user.getUsername(), user);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I delete the user by the username")
    public void callDeleteUserAPI() {
        User user = (User) dataStorage.getData("USER");
        Response response = userClient.deleteUser(user.getUsername());
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }
}
