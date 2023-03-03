package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Inventory;
import models.Order;

public class StoreSteps extends BaseSteps {

    @When("I look for the pet inventory")
    public void callGetPetInventoryAPI() {
        Response response = storeClient.getPetInventory();
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I place the order in inventory")
    public void callPlaceOrderAPI() {
        Order order = (Order) dataStorage.getData("ORDER");
        Response response = storeClient.placeOrder(order);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I look for the order id")
    public void callFindOrderById() {
        Order order = (Order) dataStorage.getData("ORDER");
        Response response = storeClient.getOrder(String.valueOf(order.getId()));
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I delete the order by id")
    public void callDeleteOrderById() {
        Order order = (Order) dataStorage.getData("ORDER");
        Response response = storeClient.deleteOrder(String.valueOf(order.getId()));
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @And("I save the original number of orders")
    public void saveNumberOfOrders() {
        Response response = (Response) dataStorage.getData("RESPONSE");
        Inventory inventoryResponse = response.as(Inventory.class);
        scenario.log("INVENTORY: " + inventoryResponse);
        dataStorage.setData("INVENTORY", inventoryResponse);
    }

    @Then("the number of {string} orders must {string}")
    public void validateOrderIncrement(String orderStatus, String validation) {
        Inventory originalInventory = (Inventory) dataStorage.getData("INVENTORY");
        Response response = (Response) dataStorage.getData("RESPONSE");
        Inventory updatedInventory = response.as(Inventory.class);
        validationService.validateInventory(updatedInventory, originalInventory, orderStatus, validation);
    }
}
