package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utilities.DataStorage;
import utilities.EnvironmentReader;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        if (null != System.getProperty("log")){
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
        }
        DataStorage dataStorage = new DataStorage();
        dataStorage.setData("Scenario", scenario);
        EnvironmentReader.load();
    }

}
