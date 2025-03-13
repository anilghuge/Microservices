### Session 01 : Introduction to Microservices
### Session 02 : Inter Communication between Microservices[Proj02]
### Session 03 : Discovery Client[Proj03,Proj04]
			-	Notes Available in Proj03
### Session 04 : LoadBalancer Client
			- Notes Available in Proj05
### Session 05 : Feign Client
            - Notes Available in Proj07
### Session 06 : Config Server With Git
	 		- Notes Available in Proj08

### Session 07 :Config Server With Native
	 		- Notes Available in Proj12
### Session 08 : API Gateway
			- We can implements Spring Cloud API in two ways
			- 1.Using Properties Configuration(take the support of application.properties or application.yml for API Gateway Configuration)
			- 2.Using Java Configuration(take the support of @Bean Methods in @Configuration class for this purpose)
			- Notes Available in Proj17
### Session 09 : Circuit Breaker Using Resilence4j
			- Notes Available in Proj21 

## Pending Topics :
- 1.Learn Service Registry Eureka,Consul,Zookeeper
- 2.Learn Actuators
- 3.Learn API Gateway
```text
list of popular API Gateway solutions that you can use with Spring Boot. 
These tools provide features like routing,load balancing, security, rate limiting, and service discovery for microservices architectures.
Here’s a list of API gateways compatible with Spring Boot, including both Spring-based solutions and third-party tools:

---

### 1. Spring Cloud Gateway
- Type: Native Spring solution (reactive, non-blocking).
- Features:
  - Route definitions with predicates and filters.
  - Integration with Spring Security, Eureka, and Circuit Breakers.
  - Built for microservices architectures.
- Website: [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

---

### 2. Netflix Zuul (Legacy)
- Type: Older Spring Cloud Netflix integration (blocking I/O, now in maintenance mode).
- Features:
  - Simple routing and filtering.
  - Integrates with Eureka for service discovery.
- Note: Deprecated in favor of Spring Cloud Gateway.
- Docs: [Netflix Zuul](https://github.com/Netflix/zuul)

---

### 3. Kong
- Type: Open-source, cloud-native API gateway (built on NGINX/Lua).
- Features:
  - Plugins for authentication, rate-limiting, and logging.
  - Scalable and Kubernetes-friendly.
- Integration: Deploy as a sidecar or standalone; works with Spring Boot apps.
- Website: [Kong](https://konghq.com/)

---

### 4. Tyk
- Type: Open-source API gateway (Go-based).
- Features:
  - Developer portal, analytics, and security policies.
  - RESTful API for configuration.
- Integration: Use alongside Spring Boot services.
- Website: [Tyk](https://tyk.io/)

---

### 5. AWS API Gateway
- Type: Fully managed serverless gateway (AWS ecosystem).
- Features:
  - Integrates with AWS Lambda, DynamoDB, and Spring Boot apps via REST/HTTP proxies.
  - Pay-per-use pricing.
- Use Case: Ideal for AWS-hosted Spring Boot apps.
- Website: [AWS API Gateway](https://aws.amazon.com/api-gateway/)

---

### 6. Azure API Management
- Type: Enterprise-grade gateway (Microsoft Azure).
- Features:
  - API versioning, analytics, and monetization.
  - Supports hybrid and multi-cloud deployments.
- Integration: Manage Spring Boot APIs on Azure.
- Website: [Azure API Management](https://azure.microsoft.com/en-us/services/api-management/)

---

### 7. Apigee (Google Cloud)
- Type: Enterprise API management platform.
- Features:
  - Traffic management, OAuth, and threat protection.
  - Advanced API analytics.
- Integration: Proxy Spring Boot APIs via Apigee.
- Website: [Apigee](https://cloud.google.com/apigee)

---

### 8. Gloo Edge (Envoy Proxy)
- Type: Kubernetes-native API gateway (built on Envoy).
- Features:
  - GraphQL support, service discovery, and security.
  - Integrates with Spring Boot and Istio.
- Website: [Gloo Edge](https://www.solo.io/products/gloo-edge/)

---

### 9. KrakenD
- Type: High-performance open-source gateway (Go-based).
- Features:
  - Aggregates REST APIs into single endpoints.
  - Minimal configuration and stateless design.
- Integration: Works with Spring Boot microservices.
- Website: [KrakenD](https://www.krakend.io/)

---

### Summary
- Spring-Native: Use Spring Cloud Gateway for modern, reactive setups.
- Cloud Providers: AWS API Gateway, Azure API Management, or Apigee for managed cloud solutions.
- Kubernetes: Gloo Edge or Kong for cloud-native environments.
- Legacy: Avoid Zuul unless maintaining older systems.
```
```text
List of Dependency :
- 1.AI
- 2.Developer Tools
- 3.Google Cloud
- 4.I/O
- 5.Messaging
- 6.Microsoft Azure
- 7.NoSQL
- 8.Observability
- 9.Ops
- 10.SQL
- 11.Security
- 12.Spring Cloud
- 13.Spring Cloud Circuit Breaker
- 14.Spring Cloud Config
- 15.Spring Cloud Discovery
- 16.Spring Cloud Messaging
- 17.Spring Cloud Routing
- 18.Template Engines
- 19.Testing
- 20.VMware Tanzu Application Service
- 21.Web
```
These categories represent different functionalities provided by Spring Boot dependencies in the latest version. Here’s a brief explanation of some key categories:

1. Spring Cloud - Provides tools for building distributed and microservice-based applications, including service discovery, configuration management, and resilience features.
2. Spring Cloud Circuit Breaker - Helps implement resilient microservices using circuit breaker patterns (e.g., Resilience4J, Hystrix).
3. Spring Cloud Config - Manages externalized configurations for microservices.
4. Spring Cloud Discovery - Supports service discovery using tools like Eureka, Consul, and Zookeeper.
5. Spring Cloud Messaging - Provides integration with messaging platforms like RabbitMQ and Kafka.
6. SQL & NoSQL - Support for relational databases (JPA, JDBC) and NoSQL databases (MongoDB, Redis, Cassandra).
7. Security - Implements authentication and authorization with Spring Security.
8. Testing - Offers testing utilities for Spring Boot applications.
9. Web - Includes Spring MVC and RESTful web services.
