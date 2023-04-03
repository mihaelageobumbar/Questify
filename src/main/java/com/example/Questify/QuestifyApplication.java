package com.example.Questify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class QuestifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestifyApplication.class, args);
    }

}
