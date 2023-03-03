package client;

import data.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Order;

import static io.restassured.RestAssured.given;
import static utilities.EnvironmentReader.getUrl;

public class StoreClient {

    public Response getPetInventory() {
        return given().baseUri(getUrl()).get(Endpoints.STORE_INVENTORY);
    }

    public Response placeOrder(Order order) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).body(order).post(Endpoints.STORE_ORDER);
    }

    public Response getOrder(String id) {
        return given().baseUri(getUrl()).pathParam("orderId", id).get(Endpoints.STORE_ORDER_BY_ID);
    }

    public Response deleteOrder(String id) {
        return given().baseUri(getUrl()).pathParam("orderId", id).delete(Endpoints.STORE_ORDER_BY_ID);
    }
}
