package com.team4.ailearneye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AiLearnEyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiLearnEyeApplication.class, args);
    }

}
