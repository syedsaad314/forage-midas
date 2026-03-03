# JPMC Midas Core - Transaction Processing Engine 🚀

### **Project Overview**
This repository contains my implementation of the **Midas Core** system, developed during the **J.P. Morgan & Co. Software Engineering Job Simulation**. The project focuses on building a robust, scalable backend for processing high-volume financial transactions using an event-driven architecture.

The core objective was to bridge the gap between real-time data ingestion (Kafka) and user-facing data access (REST APIs), ensuring data integrity and system reliability throughout the transaction lifecycle.

### **Key Engineering Contributions**
* **Event-Driven Ingestion:** Engineered an **Apache Kafka Consumer** to process real-time transaction streams, ensuring low-latency data updates.
* **RESTful Service Layer:** Designed and implemented scalable **Spring Boot REST API** endpoints to expose user balance data for external system consumption.
* **Microservices Orchestration:** Integrated an external **Incentive API** using Spring's `RestTemplate` to handle complex, cross-service reward calculations.
* **Persistent Data Layer:** Leveraged **Spring Data JPA** with an **H2 Database** to maintain a consistent state of user ledgers and transaction history.
* **Reliability & Testing:** Applied **Test-Driven Development (TDD)** using Maven to validate financial logic and system edge cases (e.g., verifying balances for high-frequency users).

### **Technical Stack**
* **Language:** Java 17
* **Framework:** Spring Boot 3.x (Web, JPA)
* **Messaging:** Apache Kafka
* **Build Tool:** Maven
* **Database:** H2 (In-memory) / SQL

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
*Note: This project was completed as a simulated task for J.P. Morgan & Co. to demonstrate proficiency in enterprise Java development and distributed systems.*
