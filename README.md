## 📌 Project Overview

This is a Spring Boot application that fetches recent earthquake data from the USGS public GeoJSON API, filters the results, stores them in a PostgreSQL database, and exposes a REST API along with a simple frontend for visualization.

This project was built as part of learning Spring Boot, working with external APIs, and handling dynamic data.

### 🔧 Tech Stack

* Spring Boot
* PostgreSQL
* Maven
* REST APIs
* GeoJSON parsing
* HTML + JavaScript (basic frontend)
* Bootstrap

---

## ⚙️ Setup Instructions

### ✅ Requirements

* Java 17+
* Maven
* PostgreSQL

---

## 🗄️ Database Configuration

Create a PostgreSQL database:

* **Database name:** `earthquake`
* **Username:** `postgres`
* **Password:** `1234`

Example `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/earthquake
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ Running the Application

Run the backend with:

```
mvn spring-boot:run
```

Then open in browser:

```
http://localhost:8080
```

The frontend is served by Spring Boot and does not require a separate setup.

---

## 📡 API Endpoints

* `GET /api/earthquakes/fetch` → Fetch and store latest earthquakes from USGS API
* `GET /api/earthquakes` → Retrieve all stored earthquakes
* `GET /api/earthquakes/after?time={timestamp}` → Filter earthquakes after a given time
* `DELETE /api/earthquakes/{id}` → Delete a specific earthquake record

---

## 🌐 Frontend

A simple frontend is implemented using HTML, Bootstrap, and JavaScript.

Features:

* Table view displaying earthquake data (magnitude, place, time)
* Fetch button to load latest data from backend

Accessible at:

```
http://localhost:8080
```

---

## 🧠 Assumptions

* Only earthquakes with magnitude greater than 2.0 are stored
* Existing data is deleted before inserting new data to avoid duplicates
* External API may return null or missing fields → handled in the service layer
* The USGS API is dynamic and data may change on each request

---

## 🚀 Optional Improvements

* Filtering earthquakes by timestamp (`/after` endpoint)
* Basic frontend visualization using Bootstrap
* Additional error handling for API and database failures
* Simple map visualization showing earthquake locations

---

## ⚠️ Exception Handling

The application handles:

* Null or missing fields in API response
* API unavailability
* Database-related errors

---

## 📥 Example Response

```

## 🧪 Testing

Basic integration tests are implemented for the service layer.
