package steps;

import client.PetClient;
import client.StoreClient;
import client.UserClient;
import data.DataProvider;
import io.cucumber.java.Scenario;
import services.ValidationService;
import utilities.DataStorage;

public class BaseSteps {

    protected DataProvider dataProvider = new DataProvider();

    protected DataStorage dataStorage = new DataStorage();

    protected Scenario scenario = (Scenario) dataStorage.getData("Scenario");

    protected PetClient petClient = new PetClient();

    protected StoreClient storeClient = new StoreClient();

    protected UserClient userClient = new UserClient();

    protected ValidationService validationService = new ValidationService();
}
