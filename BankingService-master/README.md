# Geting Started

## Checking out and building the project

```shell
git checkout git@github.com:pmanko2/BankingService.git

# Run from the ^ project root directory
gradlew build
```

## Running the Micronaut microservice

You can either use Intellij to run `Application.kt` or use gradle from the root project directory

```shell
# from the project root directory
gradlew run
```

## Sending requests to the API

After successfully running your Micronaut project, you should see output that looks like this:

```shell
 __  __ _                                  _   
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_ 
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_ 
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
  Micronaut (v2.5.4)

15:18:34.170 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 728ms. Server Running: http://localhost:8080
```

The url displayed after `Server Running:` will be the base URL of your api service. You can make HTTP requests
to this URL in order to interact with your API.

You can use a request tool of your choice to make these requests. I would suggest downloading [Postman](https://www.postman.com/downloads/) 
which is a very useful tool we use at Favor to interact and test our APIs.

You can also use CURL from your command line: [Curl Documentation](https://curl.se/docs/manpage.html)

### Getting Account Balance

URL: GET `http://localhost:8080/accounts/:id`

The request to get the balance for bank account 1 would look like `http://localhost:8080/accounts/1`

```shell
# curl command
curl --location --request GET 'http://localhost:8080/accounts/1'
```

### Depositing Money

**URL**

POST `http://localhost:8080/accounts`

**POST Body**

Depositing $20 to bank account 1
```json
{
   "bankAccountId": 1,
   "amount": 20.0
}
```

**CURL Command**
```shell
curl --location --request POST 'http://localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bankAccountId": 1,
    "amount": 20.0
}'
```

# Project Components

## AccountController
This is where we define the different HTTP routes we want our API to handle. This class follows the
principles outlined here https://docs.micronaut.io/latest/guide/index.html#routing

### Current Routes

1. GET /accounts/:id

    Gets the current account balance information for the given bank account :id


2. POST /accounts

    Accepts a new deposit to the bankAccount with the given POST body
   
    ```json
    {
        "bankAccountId": 1,
        "amount": 20.0
    }
    ```


# Micronaut Related Documentation

## Micronaut 2.5.4 Documentation

- [User Guide](https://docs.micronaut.io/2.5.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

