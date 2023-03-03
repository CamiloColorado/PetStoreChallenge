# PetStoreChallenge
## Requirements :page_with_curl:
- JDK 17
- Maven 3.9.0
- Pet Store project (https://github.com/swagger-api/swagger-petstore)

## Key libraries and tools :wrench:
- Java: Language
- Maven: Dependency Management
- TestNG: Testing
- Cucumber: BDD Management
- RestAssured: Java library to test REST APIs

## Source code structure :file_folder:
All packages and classes have been defined following SOLID principles and separated concerns.

Package list under ```/src/main/java```

- **clients:** Contains the Client classes that are used to make the requests.
- **data:** Contains the classes to genereate the data models.
- **models:** Contains the classes with the data models.
- **services:** Contains the ValidationService class that is used to make some validations.
- **steps:** Contains the mapping between the test scenarios steps, described  in the feature files, with the functions to be executed.
- **utilities:** Contains the ConfigurationFileReader class that is used to read the configuration properties file and the DataStorage class that is used to store data.

Package list under ```/src/main/resources```

- **files:** Contains the files that are used for the pet upload image operation.
- **properties:** Contains the environment properties file.
- **schemas:** Contains the json schemas.

Package list under ```/src/test/java```

- **runners:** Contains the Runner classes that are used to run the tests.

Package list under ```/src/test/resources```

- **features:** Contains the test scenarios.

## Aproach :bulb:
The following validations were setup
- Sanity test: Validates if the API operations are working.
- Schema test: Validates the response body against the expected shema.
- Response status code test: Validate status code when input values are invalid or do not exist.
- Workflow test: Validate the main workflows.

## Decisions :arrow_up_down: :left_right_arrow:
- BDD was used to improve the speed of test development and to facilitate test definition and understanding.
- A configuration properties file was used in order to allow future configurations to be added.
- Different tests were defined to validate what can go wrong in the main workflow.
- Lombok annotations were used to facilitate the models object interaction.
- Cluecumber plugin report was used to reporting the test results.

## Usage :computer:
From the command line of the project's root folder, run the following command to build project and run the project's test scenarios.

```mvn test```

After the execution is completed run the following command to generate the cluecumber report.

```mvn cluecumber-report:reporting```

A new folder will be created, the report can be found in the following structure.

```/target/generated-report/index.html```

## Authors :bust_in_silhouette:
- Camilo Colorado - [LinkedIn](https://www.linkedin.com/in/camilo-andres-colorado-ramos)
