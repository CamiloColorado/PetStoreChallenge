package steps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Pet;

import java.io.File;

public class PetSteps extends BaseSteps {

    @When("I add the new pet")
    public void callAddPetAPI() {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response = petClient.addPet(pet);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I update the new pet")
    public void callUpdatePetAPI() {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response = petClient.updatePet(pet);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I look for the pet by status {string}")
    public void callFindPetByStatusAPI(String status) {
        Response response = petClient.getPet(status);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I look for the pet by tag {string}")
    public void callFindPetByTagAPI(String tag) {
        Response response = petClient.getPetByTag(tag);
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I look for the pet by id")
    public void callFindPetByIdAPI() {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response = petClient.getPetById(String.valueOf(pet.getId()));
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I update by {string} form data the new pet")
    public void callUpdatePetByFormDataAPI(String filter) {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response;
        if (filter.equals("name")) {
            response = petClient.updatePet(String.valueOf(pet.getId()), pet.getStatus().name());
        } else {
            response = petClient.updatePet(String.valueOf(pet.getId()), pet.getName(), pet.getStatus().name());
        }
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }


    @When("I delete the new pet")
    public void callDeletePetAPI() {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response = petClient.deletePet(String.valueOf(pet.getId()));
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }

    @When("I upload a pet image")
    public void callUploadPetImageAPI() {
        Pet pet = (Pet) dataStorage.getData("PET");
        Response response = petClient.uploadPetImage(String.valueOf(pet.getId()), new File("src/main/resources/files/balon.JPG"));
        scenario.log("RESPONSE: " + response.asString());
        dataStorage.setData("RESPONSE", response);
    }
}
