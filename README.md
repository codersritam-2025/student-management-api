# Student Management REST API

A robust, enterprise-ready Backend RESTful API built using **Java and Spring Boot** to handle secure student administration workflows. This project implements clean architectural patterns, database mapping, and data encapsulation.

## 🛠️ Tech Stack & Concepts Used
* **Backend Framework:** Java 17+, Spring Boot (Spring Web, Spring Data JPA)
* **Database:** MySQL
* **Testing Tool:** Postman
* **Design Patterns:** Data Transfer Object (DTO) Pattern for secure data encapsulation and decoupling database entities from controllers.

## 🚀 Key Features Implemented
* Full **CRUD operations** (Create, Read, Update, Delete) for Student data.
* Clean separation of concerns across **Controller, Service, DTO, Entity, and Repository** layers.
* Global exception handling for smooth error management (e.g., Resource Not Found).

## 📊 API Endpoints & Verification
* **GET /api/students** — Fetches the list of all active students.
* **POST /api/students** — Creates a new student record using incoming DTO data.
* **PUT /api/students/{id}** — Updates details for an existing student by ID.
* **DELETE /api/students/{id}** — Safely removes a student record from the database.

## 🔧 Database Configuration
To run this application locally, ensure your `application.properties` file points to your local MySQL instance:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
