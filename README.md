[![Codacy Badge](https://app.codacy.com/project/badge/Grade/e7a145bedb45421cbc0abd9b9a20c992)](https://www.codacy.com/gh/Bo-row/backend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Bo-row/backend&amp;utm_campaign=Badge_Grade)
[![Bo-row](https://circleci.com/gh/Bo-row/backend.svg?style=shield)](https://app.circleci.com/pipelines/github/Bo-row/backend?branch=master)
# Borrow application backend

This project is a backend for borrow application

## Prerequisites
* Git 
* Java 11
* Docker + docker-compose

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

## Running mongodb image
You can run mongodb database by using:
```
    docker-compose up mongo
```

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew quarkusBuild
```
It produces the `backend-1.0.0-SNAPSHOT-runner.jar` file in the `/build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew quarkusBuild --uber-jar
```

The application is now runnable using `java -jar build/backend-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/backend-1.0.0-SNAPSHOT-runner`




