package client;

import data.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;

import java.io.File;

import static io.restassured.RestAssured.given;
import static utilities.EnvironmentReader.getUrl;

public class PetClient {

    public Response addPet(Pet pet) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).body(pet).post(Endpoints.PET);
    }

    public Response updatePet(Pet pet) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).body(pet).put(Endpoints.PET);
    }

    public Response getPet(String status) {
        return given().baseUri(getUrl()).queryParam("status", status).get(Endpoints.PET_BY_STATUS);
    }

    public Response getPetByTag(String tag) {
        return given().baseUri(getUrl()).queryParam("tags", tag).get(Endpoints.PET_BY_TAGS);
    }

    public Response getPetById(String id) {
        return given().baseUri(getUrl()).pathParam("petId", id).get(Endpoints.PET_BY_ID);
    }

    public Response updatePet(String id, String name, String status) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).pathParam("petId", id).queryParam("name", name).queryParam("status", status).post(Endpoints.PET_BY_ID);
    }

    public Response updatePet(String id, String status) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).pathParam("petId", id).queryParam("status", status).post(Endpoints.PET_BY_ID);
    }

    public Response deletePet(String id) {
        return given().contentType(ContentType.JSON).baseUri(getUrl()).pathParam("petId", id).delete(Endpoints.PET_BY_ID);
    }

    public Response uploadPetImage(String id, File file) {
        return given().header("Content-Type", "application/octet-stream").baseUri(getUrl()).pathParam("petId", id).body(file).post(Endpoints.PET_IMAGE);
    }
}
