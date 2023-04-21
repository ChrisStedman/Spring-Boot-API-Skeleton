# Postman Guide

## Summary
Postman is a popular platform for testing APIs, allowing users to easily create requests to call an API.

## Installation
Download Postman desktop [here](https://www.postman.com/downloads/)

## Using Postman
### Importing collections
An example Postman collection and environment has been included with the application.

Location: [postman](../postman)

In Postman Desktop:
1. Click `Import`
2. Select `Folder` tab
3. Select the `postman` directory in the project 
4. Click `Import`

### Setting your environmeent
1. Click the dropdown menu in the top-right corner which says `No environment` and select the environment imported previously named `local`

### Making a request
1. Open the `Collections` tab from the left side menu
2. Open `Example Collection > Example > Get Example`
3. Click `Send`
4. In the bottom pane you will see the response status, body and also the result of a test which can be seen in the `Tests` tab

### Creating a new request
1. In the left pane, right-click one of the folders in the collection and select `Add Request`
2. Give the request a name
3. Select the HTTP method
4. Define the URL of the endpoint
   1. Environment/Collection variables can be accessed by using the variable name inside double braces (`{{basePath}}`)
   2. Add path parameters to the URL if required by adding a colon before the parameter name (`:itemId`). You can then set the value of the parameter inside the `Params` tab
5. Add a body to the request if required by clicking the `Body` tab. To define a JSON object (as is most common), select `raw`, select `JSON` from the drop-down menu which appears and then add a JSON object in the middle pane
6. (Optional) Add tests to the request by clicking the `Test` tab, and writing your own tests in Javascript or selecting a pre-defined test from the right pane. These tests will run after a response is received.