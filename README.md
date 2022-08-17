## Hico-Group Demo Api

#### Description:

This is a demo Api built for the Hico-Group assessment test.

The key functionality for this Api backend is to send/receive employee data to end users.

#### Technologies:

- Java - JDK 17
- MySQL V8
- Spring Boot
- JPA
- Dotenv
- Gradle
- JWT - Json Web Token
- Logbook - Request logger
- OpenAPI
- Swagger-UI
- Org.JSON - Json library

#### Installation:

1. Install Java JDK or JRE ^17
2. Install Gradle
3. Install Docker
4. Install docker-compose
5. Copy env-example and rename it to .env

#### Env:

Below is the env options that needs to be specified to run the application:

```
JWT_SECRET -> A string of random characters and digits in order to sign a JWT token.
DB_HOST -> MySQL host address (default is 127.0.0.1)
DB_PORT -> MySQL port (default is 3306)
DB_USERNAME -> MySQL database user (default is hico_demo_user)
DB_PASSWORD -> MySQL password (default is password)
DB_DATABASE -> MySQL database (default is hico_demo)
FRESH_INITIALIZE -> Enable this if you want to create a fresh initialization of the database (default is True)

```

#### Running:

Run the following commands in the terminal or command prompt:

Run the docker container:

```bash
docker-compose up -d
```

Run the application

```bash
gradle bootRun
```

To build it run:

```bash
gradle build
```

Running the jar file:

Navigate to build/libs and run the following:

```bash
java -jar demo-0.0.1-SNAPSHOT-plain.jar
```
