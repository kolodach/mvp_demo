# Android Test Project
This repository contains an example application that implements the MVP architecture pattern. The application displays common information from https://lcboapi.com/ such as a list of stores, store details, and products associated with a store. It emulates basic authorization to
authenticate the user (use joe.doe@test.com 12345678 as a test user account, or create your own).

## Architecture
The application uses a simplified version of Clean architecture with some specific variations such as reactive programming style.
The Data Flow follows the next scheme, except for Use Causes, which looks redundant for this project:
![alt text](https://fernandocejas.com/assets/migrated/clean_architecture_evolution.png "Reactive Data Flow")

Data Flow implemented using [RxJava2] (https://github.com/ReactiveX/RxJava). MVP implemented using [Moxy] (https://github.com/Arello-Mobile/Moxy) library. App uses Dependency
Injection pattern to satisfy project dependencies. DI implemented using [Dagger2] (https://google.github.io/dagger/).
Data access layer is implemented using the Repository pattern and uses offline first approach, which means that all downloaded data is available
when a device is offline.

## API
As I noticed, the app uses the LCBO API as a remote data source. App uses [Retrofit2] (http://square.github.io/retrofit/) as a networking library
and [OkHttp] (http://square.github.io/okhttp/) as an HTTP client.

## Persistence
The application uses SQL database to store all data locally. There are 3 main tables in DB schema:
* Store - represents store object.
* Product - Represents products in a Store.
* Inventory - A helper table that describes the availability of a Product in a specific Store.
