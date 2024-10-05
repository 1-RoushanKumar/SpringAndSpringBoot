package com.rOushan.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}

/**
 * Bean Scopes in Spring:
 *
 * - **Scope** refers to the lifecycle of a Spring bean.
 * - It defines:
 *     1. **How long the bean will live** (its lifetime in the container).
 *     2. **How many instances are created**.
 *     3. **How the bean is shared within the application**.
 *
 * Default Scope: **Singleton**
 * - By default, Spring beans are **singleton** scoped.
 * - A singleton-scoped bean means:
 *     - The Spring container creates only **one instance** of the bean.
 *     - This single instance is shared across all parts of the application.
 * - Every dependency injection for that bean will reference the **same bean instance**.
 *
 * Example:
 * ```java
 * @Qualifier("cricketCoach") Coach theCoach;
 * @Qualifier("cricketCoach") Coach theAnotherCoach;
 * ```
 * - Here, both `theCoach` and `theAnotherCoach` will point to the **same instance** of the `CricketCoach` bean.
 * - You can explicitly define this scope using `@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)`.
 *
 * Prototype Scope:
 * - The **prototype** scope creates a **new bean instance** for every container request.
 * - Every time the bean is requested, a new instance is created and returned.
 *
 * Example:
 * ```java
 * @Qualifier("cricketCoach") Coach theCoach;
 * @Qualifier("cricketCoach") Coach theAnotherCoach;
 * ```
 * - In this case, `theCoach` and `theAnotherCoach` will refer to **different instances** of the `CricketCoach` bean.
 * - You can explicitly define this scope using `@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)`.
 */
