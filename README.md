# Muber API - Java Spring Boot Application
## Overview
Muber is a RESTful API-based application that simulates the functionality of a ride-hailing service similar to Uber. This project is built using Java and Spring Boot, providing services for managing passengers, drivers, and trips. It supports operations like registering new users, listing available drivers or passengers, and managing travel bookings.

## Requirements
Java 11+
Maven
Spring Boot
Gson

## Installation

1. Clone the repository.

2. Navigate to the project directory:
cd muber-api

3. Build the project:
mvn clean install

4. Run the application:
mvn spring-boot:run

5. The API will be available at http://localhost:8080/MuberRESTful.

## Endpoints

### Passenger Management
- List all passengers

    - URL: /services/pasajeros
    - Method: GET
    - Description: Fetches all registered passengers.
    - Example:
        curl -X GET http://localhost:8080/MuberRESTful/rest/services/pasajeros

- Create a new passenger

    - URL: /services/pasajeros/nuevo
    - Method: POST
    - Description: Registers a new passenger with name, password, and credit.
    - Example body:
        {
        "name": "John Doe",
        "password": "password123",
        "credit": 1000.0
        }
    - Example:
        curl -X POST -H "Content-Type: application/json" -d '{"name":"John","password":"pass","credit":1000}' http://localhost:8080/MuberRESTful/rest/services/pasajeros/nuevo
- Charge credit to a passenger

    - URL: /services/pasajeros/cargarCredito
    - Method: PUT
    - Description: Adds credit to a passenger's account.
    - Example body:
        {
        "pasajeroId": 5,
        "monto": 150.0
        }
    - Example:
        curl -X PUT -H "Content-Type: application/json" -d '{"pasajeroId":5,"monto":150}' http://localhost:8080/MuberRESTful/rest/services/pasajeros/cargarCredito

### Driver Management
- List all drivers
    - URL: /services/conductores
    - Method: GET
    - Description: Fetches all registered drivers.
    - Example:
        curl -X GET http://localhost:8080/MuberRESTful/rest/services/conductores
- Get driver details
    - URL: /services/conductores/detalle
    - Method: GET
    - Description: Fetches details of a specific driver.
    - Example:
        curl -X GET http://localhost:8080/MuberRESTful/rest/services/conductores/detalle?conductorId=1
- List top 10 drivers
    - URL: /services/conductores/top10
    - Method: GET
    - Description: Fetches the top 10 drivers without open trips.
    - Example:
        curl -X GET http://localhost:8080/MuberRESTful/rest/services/conductores/top10

### Travel Management
- List open trips
    - URL: /services/viajes/abiertos
    - Method: GET
    - Description: Fetches all available trips that are not yet completed.
    - Example:
        curl -X GET http://localhost:8080/MuberRESTful/rest/services/viajes/abiertos
- Create a new trip
    - URL: /services/viajes/nuevo
    - Method: POST
    - Description: Registers a new trip with the required details.
    - Example body:
        {
        "origen": "Start",
        "destino": "End",
        "conductorId": 1,
        "costoTotal": 150.50,
        "cantidadPasajeros": 3
        }
    - Example:
        curl -X POST -H "Content-Type: application/json" -d '{"origen":"Start","destino":"End","conductorId":1,"costoTotal":150.50,"cantidadPasajeros":3}' http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo
- Rate a trip
    - URL: /services/viajes/calificar
    - Method: POST
    - Description: Allows a passenger to rate a specific trip.
    - Example body:
        {
        "viajeId": 1,
        "pasajeroId": 2,
        "puntaje": 5,
        "comentario": "Excellent trip!"
        }
    - Example:
        curl -X POST -H "Content-Type: application/json" -d '{"viajeId":1,"pasajeroId":2,"puntaje":5,"comentario":"Excellent"}' http://localhost:8080/MuberRESTful/rest/services/viajes/calificar

## Testing
You can use curl commands or tools like Postman to test the API endpoints.

## Author
David Huertas - BBDD2 2017 UNLP