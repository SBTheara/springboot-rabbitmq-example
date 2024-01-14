package com.theara.springbootrabbitmqexample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theara.springbootrabbitmqexample.model.dto.MailRequest;
import com.theara.springbootrabbitmqexample.model.dto.MultipleMailRequest;
import com.theara.springbootrabbitmqexample.service.RabbitMQProducer;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Slf4j
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/send")
    private ResponseEntity<String> sendMessageWithoutAttachment(@RequestBody MailRequest mailRequest) throws JsonProcessingException {
        rabbitMQProducer.sendMessageWithoutAttachment(mailRequest);
        return ResponseEntity.ok("Message sent to ADMIN ... ");
    }

    @PostMapping("/send/attachment")
    private ResponseEntity<String> sendMessageWithAttachment(@RequestBody MailRequest mailRequest) throws JsonProcessingException {
        rabbitMQProducer.sendMessageWithAttachment(mailRequest);
        return ResponseEntity.ok("Message sent to ADMIN ... ");
    }

    @PostMapping("/send/batch")
    private ResponseEntity<String> sendMessageWithoutAttachment(@RequestBody MultipleMailRequest mailRequest) throws JsonProcessingException {
        rabbitMQProducer.sendMessageWithoutAttachment(mailRequest);
        return ResponseEntity.ok("Message sent to ADMIN ... ");
    }

}
