# Spring-API-Skeleton

## 📜 Overview

A skeleton of a Spring-boot REST API skeleton which can be used to teach the basics of API development, or a starting point of a  new project.

Examples which increase in complexity/functionality have been included to illustrate how different tools can be used.

### Includes:

| Functionality                     | Dependency                  |
|-----------------------------------|-----------------------------|
| Generate code from specifications | OpenApi Generator           |
| Postgres connectivity             | Docker</br>Postgres</br>JPA |
| Generate boilerplate code         | Lombok                      |
| Map between POJOs                 | MapStruct                   |

## 🔨 Project Setup
Depending on your local setup, some of these steps may not be required.

### Set JAVA_HOME to corretto-17
1. Download Corretto 17
   1. Broswer: https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html
   2. IntelliJ:
      1. File > Project Structure > Project
      2. Edit > + > `add sdk` > `download`
2. Set `JAVA_HOME` in bash profile

### Set Project SDK
1. File > Project Structure > Project
2. Set `SDK` to `corretto-17`
    1. May need to select `add sdk` and `download`
3. Apply

### Set Gradle JVM
1. IntelliJ IDEA > Preferences
2. Build, Execution and  Deployment > Build Tools > Gradle
    1. Or search `Gradle`
3. At bottom, set `Gradle JVM` to `Prokect SDK`
    1. This should be `corretto-17`

### Reload project
Even after making these changes, IntelliJ may not correctly configure the project. 
You can force IntelliJ to reload the project from scratch by exiting IntelliJ, deleting the `.idea` directory
in the project, and opening the project again.


## 🏃 Running Project
When the project is configured correctly, a Spring run configuration will be created automatically.
Simply click play, wait for the application to load and use Postman to send some requests.

_If a configuration was not created, it is likely due to a project configuration issue. Check the `Project Setup` section again_

By default, the application will use an in-memory H2 database.  
To access the H2 console:
1. Search the console for the text `Database available at` (output during startup) and copy the value after it.  
   - E.g. `jdbc:h2:mem:ed52ba88-3369-46e6-89c3-5974a844db46`
2. Go to `http://localhost:8080/h2-console/`
3. Set `JDBC URL` to the copied value
4. Connect




## 🎯 Usage
### Hitting an endpoint
Once the application is running, the defined endpoints can be called. 
The `main` branch contains an example endpoint `GET /example`, as well as a health endpoint `GET /health`.
The definition of the `/example` endpoint can be found in the specification file `api-specifications.yaml`. See the [OpenApi Generator](#openapi-generator) guide for more information.

Open Postman, import the example postman collection, and call the `/example` endpoint. You should receive a 200 status with the body seen below. For more information of installing, configuring and using postman, see the [Postman](#postman) guide.

```
{
    "Status": "Success"
}
```

### Creating an endpoint
Open the specification file `api-specification.yaml`. OpenApi generator uses this file to generate the required API and model classes for the API.

Add a new `path`, a nested `http method` and at least one response to define a basic endpoint. Ideally, also add a `tag` and `operation-id` to improve the generated classes.
Use the pre-defined `/example` endpoint as a template, and see the [OpenApi Generator](#openapi-generator) guide for more information.

Click the `build` button in IntelliJ, or run `gradle build` from the `Gradle` tab.

Create a new `delegateImpl` which extends the generated `apiDelegate` interface. Now override the method defined in the `apiDelegate` interface to define the handling of the endpoint.
Use the pre-defined class `ExampleApiDelegateImpl`  as a template.

Create a new postman request to hit the newly created endpoint. See the [Postman](#postman) guide for more information.

Run the application and hit the new endpoint using Postman.

## 👌 Guides
#### [OpenApi Generator](docs/OpenApi-Generator.md)
#### [Postman](docs/Postman.md)  
