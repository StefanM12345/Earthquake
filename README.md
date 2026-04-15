## 📌 Project Overview

This is a Spring Boot application that fetches recent earthquake data from the USGS public GeoJSON API, filters the results, stores them in a PostgreSQL database, and exposes a REST API along with a simple frontend for visualization.

### 🔧 Tech Stack

* Spring Boot
* PostgreSQL
* Maven
* REST APIs
* GeoJSON parsing
* HTML + JavaScript (basic frontend)

---

## ⚙️ Setup Instructions

### ✅ Requirements

* Java 17+
* Maven
* PostgreSQL

### 🗄️ Database Configuration

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

---

## 📡 API Endpoints

* `GET /api/earthquakes/fetch` → Fetch and store latest earthquakes
* `GET /api/earthquakes` → Get all stored earthquakes
* `GET /api/earthquakes/after?time={timestamp}` → Filter by time
* `DELETE /api/earthquakes/{id}` → Delete earthquake by ID

---

## 🧠 Assumptions

* Only earthquakes with magnitude > 2.0 are stored
* Existing data is cleared before inserting new data
* API responses may contain null values → handled in code

---

## 🌐 Frontend

A simple frontend is included for visualization using HTML and JavaScript.
Accessible at:

```
http://localhost:8080
```

---

