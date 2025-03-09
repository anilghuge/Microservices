![Config Server](ConfigServer.png)

Config Server in Spring Boot is a part of the Spring Cloud suite, which is used to manage the external properties and configurations for distributed systems. Spring Cloud Config provides server and client support for externalized configuration in a distributed system. It allows you to store configuration properties outside the application code, making it easier to manage configurations in a microservices architecture.

### Steps to set up Spring Cloud Config Server in Spring Boot

#### 1. Create a Spring Boot Application

Start by creating a Spring Boot application. You can do this by using Spring Initializr (https://start.spring.io/) or by setting up a project manually.

- Group: `com.example`
- Artifact: `config-server`
- Dependencies: Spring Cloud Config Server, Spring Boot DevTools (optional), and Spring Web.

#### 2. Add the Required Dependencies

In your `pom.xml` (if you are using Maven), add the Spring Cloud dependencies for the Config Server:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

Also, add the Spring Cloud version in your `pom.xml`:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>2020.0.4</version> <!-- Choose the appropriate version -->
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

> **Note:** Make sure to use the correct version of Spring Cloud that is compatible with your Spring Boot version.

#### 3. Enable Config Server

In your main Spring Boot application class, add the `@EnableConfigServer` annotation to enable the Config Server:

```java
package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

#### 4. Configure the Application Properties

In your `application.properties` or `application.yml` file, configure the location where the configuration files will be fetched from. This can be a Git repository, a file system, or a Vault server.

Example using a Git repository:

```properties
spring.cloud.config.server.git.uri=https://github.com/yourusername/your-config-repo.git
spring.cloud.config.server.git.clone-on-start=true
spring.application.name=config-server
server.port=8888
```

Here:
- `spring.cloud.config.server.git.uri` points to your Git repository containing configuration files.
- `server.port` is the port on which your Config Server will run (default is `8888`).

#### 5. Create a Configuration Repository

Create a Git repository (or use an existing one) to store your externalized configuration files. These files typically have the following structure:

```
/config-repo
    /application.yml
    /my-service-dev.yml
    /my-service-prod.yml
```

Here, `application.yml` is the default configuration file, and `my-service-dev.yml` and `my-service-prod.yml` are environment-specific configurations.

Example of `application.yml`:

```yaml
server:
  port: 8080
```

#### 6. Run the Config Server

Run your Spring Boot application:

```bash
mvn spring-boot:run
```

Now your Config Server should be running on port 8888 (or any other port you've configured). It will serve configuration properties from your Git repository (or another source).

#### 7. Connect Your Clients to the Config Server

To connect a client service to the Config Server, add the Spring Cloud Config Client dependency in the client service’s `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

In the `application.properties` of the client service, configure the Config Server URL:

```properties
spring.cloud.config.uri=http://localhost:8888
spring.application.name=my-service
```

When the client service starts, it will connect to the Config Server to fetch the configuration.

#### 8. Test the Config Server

You can test the Config Server by accessing the following URL in your browser or through a tool like `curl`:

```bash
http://localhost:8888/my-service/default
```