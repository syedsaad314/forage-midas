# JPMC - Midas Core Transaction System (Job Simulation)

This repository contains my work for the **J.P. Morgan & Co. Software Engineering Virtual Experience**. I developed and integrated backend microservices for the "Midas Core" system to handle high-volume financial transactions in my Virtual Simulation.

## 🚀 Key Features
* **Event-Driven Processing:** Implemented an **Apache Kafka** consumer to process real-time transaction streams.
* **REST API Development:** Created a **Spring Boot** controller to handle user balance queries via GET requests.
* **Service Integration:** Integrated an external **Incentive API** using `RestTemplate` for cross-service communication.
* **Data Persistence:** Managed relational data using **Spring Data JPA** and **H2 Database**.
* **Automated Testing:** Followed **Test-Driven Development (TDD)** using Maven to ensure 100% logic accuracy.

## 🛠️ Tech Stack
* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Messaging:** Apache Kafka
* **Database:** H2 (In-memory)
* **Build Tool:** Maven

## 📖 How to Run
1. **Clone the repository:**
   `git clone https://github.com/syedsaad314/forage-midas.git`
2. **Start the Incentive API:**
   `java -jar services/transaction-incentive-api.jar`
3. **Run the Application:**
   `./mvnw spring-boot:run`
4. **Run Tests:**
   `./mvnw test -Dtest=TaskFiveTests`

---
*Developed as part of the J.P. Morgan Software Engineering Virtual Experience via Forage.*
