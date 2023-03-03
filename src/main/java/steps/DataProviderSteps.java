package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import models.Order;
import models.Pet;
import models.User;

public class DataProviderSteps extends BaseSteps {

    @Given("a new pet")
    public void generatePet() {
        Pet pet = dataProvider.generatePet();
        scenario.log("PET: " + pet);
        dataStorage.setData("PET", pet);
    }

    @Given("a new order for a pet")
    public void generateOrder() {
        Order order = dataProvider.generateOrder();
        scenario.log("ORDER: " + order);
        dataStorage.setData("ORDER", order);
    }

    @Given("a new user")
    public void generateUser() {
        User user = dataProvider.generateUser();
        scenario.log("USER: " + user);
        dataStorage.setData("USER", user);
    }

    @And("I change the {string} for the user")
    public void updateUserFields(String field) {
        Response response = (Response) dataStorage.getData("RESPONSE");
        User userResponse = response.as(User.class);
        userResponse = dataProvider.updateUserField(userResponse, field);
        scenario.log("USER: " + userResponse);
        dataStorage.setData("USER", userResponse);
    }

    @And("I set the value {string} in the {string} for the order")
    public void updateOrderFields(String value, String field) {
        Order orderResponse = (Order) dataStorage.getData("ORDER");
        orderResponse = dataProvider.updateOrderField(orderResponse, field, value);
        scenario.log("ORDER: " + orderResponse);
        dataStorage.setData("ORDER", orderResponse);
    }

    @And("I change the {string} for a pet")
    public void updatePetFields(String field) {
        Response response = (Response) dataStorage.getData("RESPONSE");
        Pet petResponse = response.as(Pet.class);
        petResponse = dataProvider.updatePetField(petResponse, field);
        scenario.log("PET: " + petResponse);
        dataStorage.setData("PET", petResponse);
    }
}
