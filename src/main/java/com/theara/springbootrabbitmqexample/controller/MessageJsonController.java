package com.theara.springbootrabbitmqexample.controller;

import com.theara.springbootrabbitmqexample.model.dto.User;
import com.theara.springbootrabbitmqexample.service.RabbitMQJsonProducer;
import com.theara.springbootrabbitmqexample.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/json-message")
@Slf4j
public class MessageJsonController {
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    private ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to ADMIN ... ");
    }
}
