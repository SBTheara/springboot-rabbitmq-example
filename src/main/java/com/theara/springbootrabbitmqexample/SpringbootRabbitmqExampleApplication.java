package com.theara.springbootrabbitmqexample;

import com.rabbitmq.stream.Consumer;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRabbitmqExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqExampleApplication.class, args);
        Environment environment = Environment.builder()
                .uri("rabbitmq-stream://guest:guest@localhost:5552")
                .build();
        Producer producer = environment.producerBuilder()
                .stream("my-stream")
                .build();
    }

}
