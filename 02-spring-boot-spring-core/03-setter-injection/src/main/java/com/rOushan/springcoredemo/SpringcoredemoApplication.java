package com.rOushan.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}

/*
 * Comparison between Constructor Injection and Setter Injection:
 *
 * 1. **Definition**:
 *    - Constructor Injection provides dependencies through the constructor when the object is created.
 *    - Setter Injection provides dependencies through setter methods after the object is created.
 *
 * 2. **Initialization**:
 *    - Constructor Injection requires all dependencies to be provided at the time of object creation, ensuring the object is fully initialized.
 *    - Setter Injection allows dependencies to be set or modified after the object is created, which can lead to partial initialization.
 *
 * 3. **Immutability**:
 *    - Constructor Injection promotes immutability; once dependencies are set, they cannot be changed.
 *    - Setter Injection allows dependencies to be mutable; they can be changed at any time during the object's lifecycle.
 *
 * 4. **Required vs. Optional**:
 *    - Constructor Injection requires all dependencies; if a required dependency is missing, the object cannot be created.
 *    - Setter Injection allows for optional dependencies, as not all dependencies need to be provided upfront.
 *
 * 5. **Testability**:
 *    - Constructor Injection makes testing easier since all dependencies are provided at the time of construction.
 *    - Setter Injection may complicate testing as dependencies may need to be set separately after the object is created.
 *
 * 6. **Readability**:
 *    - Constructor Injection can lead to complex constructor signatures if many dependencies are required, reducing readability.
 *    - Setter Injection can enhance readability by keeping the constructor cleaner, especially for classes with numerous dependencies.
 *
 * 7. **Usage in Frameworks**:
 *    - Constructor Injection is commonly used in frameworks like Spring, where beans are instantiated with required dependencies.
 *    - Setter Injection is also widely used in frameworks like Spring, particularly for optional or changing dependencies.
 *
 * 8. **Example**:
 *    - Constructor Injection Example:
 *      ```java
 *      @Autowired
 *      public DemoController(Coach mycoach) {
 *          this.mycoach = mycoach;
 *      }
 *      ```
 *    - Setter Injection Example:
 *      ```java
 *      @Autowired
 *      public void setCoach(Coach mycoach) {
 *          this.mycoach = mycoach;
 *      }
 *      ```
 *
 * **Summary**:
 * - Constructor Injection is ideal for mandatory dependencies, ensuring the object is fully initialized before use and promoting immutability and ease of testing.
 * - Setter Injection provides flexibility for optional dependencies and allows changes to dependencies after object creation but may risk partial initialization and mutable state.
 */
