# **Microservices Course Projects**

This repository contains various projects and notes based on the sessions of a microservices course. Each session covers different concepts related to microservices architecture and implementation using **Spring Boot**, **Spring Cloud**, and other related technologies.

## **Table of Contents**

- [Session 01: Introduction to Microservices](#session-01-introduction-to-microservices)
- [Session 02: Inter Communication between Microservices](#session-02-inter-communication-between-microservices)
- [Session 03: Discovery Client](#session-03-discovery-client)
- [Session 04: LoadBalancer Client](#session-04-loadbalancer-client)
- [Session 05: Feign Client](#session-05-feign-client)
- [Session 06: Config Server with Git](#session-06-config-server-with-git)
- [Session 07: Config Server with Native](#session-07-config-server-with-native)
- [Session 08: API Gateway](#session-08-api-gateway)
- [Session 09: Circuit Breaker Using Resilience4j](#session-09-circuit-breaker-using-resilience4j)

---

## **Session 01: Introduction to Microservices**

- **Overview**: This session introduces the microservices architecture, its benefits, and why it's preferred over monolithic architectures.
- **Topics Covered**:
  - What is Microservice Architecture?
  - Benefits and Challenges of Microservices
  - Introduction to Spring Boot for Microservices Development
  
---

## **Session 02: Inter Communication between Microservices [Proj02]**

- **Overview**: This session focuses on the different methods for inter-service communication in a microservices environment.
- **Topics Covered**:
  - Synchronous vs Asynchronous Communication
  - REST API Communication
  - Message Brokers (e.g., RabbitMQ, Kafka)
  - **Project 02**: Demonstrating inter-service communication with REST APIs
  
---

## **Session 03: Discovery Client [Proj03, Proj04]**

- **Overview**: This session covers service discovery, a key component of microservices architecture that allows services to locate and communicate with each other dynamically.
- **Topics Covered**:
  - What is Service Discovery?
  - Using Eureka for Service Discovery
  - **Project 03**: Service discovery with Spring Cloud Eureka
  - **Project 04**: Advanced Eureka configurations
  - **Notes Available in Proj03**

---

## **Session 04: LoadBalancer Client [Proj05]**

- **Overview**: In this session, we learn how to implement load balancing in microservices architectures to distribute traffic efficiently across instances.
- **Topics Covered**:
  - What is Load Balancing?
  - Client-Side Load Balancing with Ribbon
  - **Project 05**: Load balancing with Spring Cloud and Ribbon
  - **Notes Available in Proj05**

---

## **Session 05: Feign Client [Proj07]**

- **Overview**: This session introduces **Feign**, a declarative HTTP client that makes it easier to call REST APIs from a microservice.
- **Topics Covered**:
  - Introduction to Feign Client
  - Feign with Spring Cloud
  - **Project 07**: Feign Client Implementation for Microservices Communication
  - **Notes Available in Proj07**

---

## **Session 06: Config Server with Git [Proj08]**

- **Overview**: This session explains how to centralize configuration management using Spring Cloud Config Server and Git.
- **Topics Covered**:
  - Centralized Configuration Management
  - Setting up Spring Cloud Config Server with Git
  - **Project 08**: Implementing Config Server with Git
  - **Notes Available in Proj08**

---

## **Session 07: Config Server with Native [Proj12]**

- **Overview**: In this session, we explore how to configure Spring Cloud Config Server with native files (e.g., YAML/Properties files) instead of Git repositories.
- **Topics Covered**:
  - Spring Cloud Config Server with Native Configuration
  - Advantages of Using Native Configuration
  - **Project 12**: Config Server with Native Files
  - **Notes Available in Proj12**

---

## **Session 08: API Gateway**

- **Overview**: This session explains how to implement an **API Gateway** to handle routing, filtering, and load balancing for microservices.
- **Topics Covered**:
  - What is an API Gateway?
  - Spring Cloud Gateway
  - Configuration Approaches:
    - Using Properties Configuration (application.properties or application.yml)
    - Using Java Configuration (@Bean Methods in @Configuration classes)
  - **Notes Available in Proj17**

---

## **Session 09: Circuit Breaker Using Resilience4j [Proj21]**

- **Overview**: In this session, we implement the **Circuit Breaker Design Pattern** using **Resilience4j** to improve fault tolerance in microservices.
- **Topics Covered**:
  - What is the Circuit Breaker Pattern?
  - Introduction to Resilience4j
  - Handling Failures and Fallback Mechanisms
  - **Project 21**: Implementing Circuit Breaker using Resilience4j
  - **Notes Available in Proj21**

---

## **Getting Started**

### Prerequisites

- **Java**: 17 or later
- **Spring Boot**: 3.x
- **Maven**: 3.x or Gradle
- **IDE**: Any IDE (e.g., IntelliJ IDEA, Eclipse)
- **Docker** (Optional for containerization)
  
### Cloning the Repository

You can clone this repository to your local machine using:

```bash
git clone https://github.com/anilghuge/Microservices.git
cd Microservices
```

### Building and Running the Projects

Each project is self-contained and can be run individually. To run a specific project, navigate to the project folder and execute the following:

#### Using Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

#### Using Gradle:

```bash
./gradlew build
./gradlew bootRun
```
