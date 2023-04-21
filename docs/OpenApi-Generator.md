# OpenAPI Generator Guide

## Summary
OpenAPI Generator is a library which can generate code form OpenAPI specifications. Simply define an API in an Open API formatted YAML or JSON file, create a a task in `build.gradle` which specifies the input file and output directory, and the generator will generate everything you need for a working endpoint.

## Basic tructure of an OpenAPI specification
Every OpenAPI specification requires the following sections at a minimum

### Metadata
This defines the version of OpenAPI to be used. It appears as the first line of the specification

#### Metadata example
```
openapi: 3.0.3
```
  
### Paths
The paths section defines the endpoints of your API, and the HTTP methods they support.

#### GET /items example

A basic `GET /items` endpoint which returns an array of strings can be defined like this:

```
paths:
  /items:
    get:
      tags:
        - Items
      operationId: get-items
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema: 
                type: array
                items: 
                  type: string
```
##### Property explanation

| Property               | Purpose                                                                                                                                                                                    |
|------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /items:                | The path of the endpoint<br/>Can support multiple HTTP methods                                                                                                                             |
| get:                   | The supported HTTP method of the endpoint                                                                                                                                                  |
| tags:<br/>  - Items    | Defines the name of the generated API, Controller and Delegate classes because of the generate task config option `useTags: "true"`<br/><br/>E.g. `ItemsApiController`, `ItemsApiDelegate` |
| operationId: get-items | Defines the name of the generated method of the endpoint<br/>E.g. `getItems`                                                                                                               |
| responses:<br/>...     | Defines the responses the endpoint can return                                                                                                                                              |

### Components
The components section allows you to define responses and schemas (objects) which can be `referenced` from within the specification, allowing for reusability.

Additionally, OpenAPI generator will generate classes based on schema names, allowing you to define the names of your models. Any schema objects defined `inline` will be named according to the default naming pattern which can result in very long and complex naming depending on the path.

#### Defining a schema
This will result in a generated model named `Status`
```
components:
  schemas:
    Status:
      title: Status
      type: string
```

#### Referencing a schema
```
 schema:
   $ref: '#/components/schemas/Status'
```

#### Defining a response
```
components:
  responses:
    404:
      description: Not found
      content:
        application/json:
          schema:
            $ref: '#/components/schemas/Status'
```

## App example

### Specification
A simple specification is included in the application which defines a `GET /example` endpoint.

Path: [app/src/main/resources/api-specification.yaml](../app/src/main/resources/api-specification.yaml)

Modify this file to change this endpoint, or create a new one.

### Generated classes
Models, controllers and delegate classes will be generated from this specification when the application is built.

Path: [app/build/generated/src/main/java/com/example/skeleton/api](../app/build/generated/src/main/java/com/example/skeleton/api)

_Note: Link will only work after application has been built and files have been generated_

### Creating custom API logic

The generated `ExampleApiDelegate` class defines a default `NOT_IMPLEMENTED` response for the endpoint. To define custom logic a new delegate must be created which implements this interface and overrides the method for the endpoint `getExample()`.

An example delegate implementation which returns a hard-coded success status has been created.

Path: [app/src/main/java/com/example/skeleton/api/delegate](../app/src/main/java/com/example/skeleton/api/delegate)


## Additional resources
[Swagger - Basic Structure](https://swagger.io/docs/specification/basic-structure/)  
[Smartbear - OpenAPI 3.0 Tutorial](https://support.smartbear.com/swaggerhub/docs/tutorials/openapi-3-tutorial.html)  
[Swagger - OpenAPI Specification](https://swagger.io/specification/)  
[OpenAPI Specification Github](https://github.com/OAI/OpenAPI-Specification)
