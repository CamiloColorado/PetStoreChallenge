package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

public class GenericValidationSteps extends BaseSteps {

    @Then("the status code is {int}")
    public void validateStatusCode(int statusCode) {
        Response response = (Response) dataStorage.getData("RESPONSE");
        Assert.assertEquals(response.getStatusCode(), statusCode, "The status codes doesn't match");
    }

    @And("the schema {string} is correct")
    public void validateSchema(String schema) {
        Response response = (Response) dataStorage.getData("RESPONSE");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/schemas/" + schema)));
    }
}
