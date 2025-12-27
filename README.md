

# 🗂️ Task Management System – Spring Boot

A **RESTful Task Management System** built using **Spring Boot**, designed with clean architecture and best practices.
This project allows managing users, tasks, assignments, and task status efficiently.

---

## 🚀 Features

* User management (Create, Read)
* Task creation & updates
* Task assignment to users
* Task status tracking
* RESTful APIs
* Global exception handling
* Layered architecture (Controller → Service → Repository)
* Spring Security integration
* JPA & Hibernate ORM
* H2 / MySQL database support

---

## 🛠️ Tech Stack

| Category   | Technology      |
| ---------- | --------------- |
| Language   | Java            |
| Framework  | Spring Boot     |
| Security   | Spring Security |
| ORM        | Hibernate (JPA) |
| Database   | MySQL / H2      |
| Build Tool | Maven           |
| Testing    | JUnit           |
| API Style  | REST            |

---

## 📁 Project Structure

```
TaskManagementSystem
│
├── src/main/java/com/example/taskmanagementsystem
│   ├── controller        # REST Controllers
│   ├── service
│   │   ├── impl           # Service Implementations
│   │   └── interfaces     # Service Interfaces
│   ├── repository         # JPA Repositories
│   ├── model              # Entity Classes
│   ├── config             # Security Configuration
│   ├── exception          # Global Exception Handling
│   ├── aop                # Logging Aspect
│   └── TaskManagementSystemApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── src/test/java
│   └── TaskManagementSystemApplicationTests.java
│
├── pom.xml
└── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/task-management-system.git
cd task-management-system
```

---

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

*(You can also switch to H2 for testing.)*

---

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

Server starts at:

```
http://localhost:8080
```

---

## 🔐 Security

* Basic authentication enabled
* Configured using Spring Security
* Security rules defined in `SecurityConfig.java`

---

## 🔗 Sample API Endpoints

### 🧑 User

* `POST /api/users`
* `GET /api/users/{id}`

### 📋 Task

* `POST /api/tasks`
* `GET /api/tasks`
* `PUT /api/tasks/{id}`
* `DELETE /api/tasks/{id}`

### 🔗 Task Assignment

* `POST /api/task-assignments`
* `GET /api/task-assignments`

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 🌱 Future Improvements

* JWT Authentication
* Role-based access (ADMIN / USER)
* Pagination & Sorting
* Swagger (OpenAPI) documentation
* Docker support

---

## 👨‍💻 Author

**Harish Saravanan**
B.Tech – Information Technology
Sri Krishna College of Engineering and Technology

