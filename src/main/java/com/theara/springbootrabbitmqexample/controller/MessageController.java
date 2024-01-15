package com.theara.springbootrabbitmqexample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theara.springbootrabbitmqexample.model.dto.MailRequest;
import com.theara.springbootrabbitmqexample.model.dto.MultipleMailRequest;
import com.theara.springbootrabbitmqexample.service.RabbitMQProducer;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Slf4j
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;
    private final StreamBridge streamBridge;

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

    //spring-cloud

    @PostMapping("/send-with-spring-cloud")
    private ResponseEntity<String> sendWithSpringCloud(@RequestBody @Valid MailRequest mailRequest){
        streamBridge.send("send",mailRequest);
        return ResponseEntity.ok("Message sent !!!");
    }

    @PostMapping("/send-with-spring-cloud-batch")
    private ResponseEntity<String> sendWithSpringCloudBatch(@RequestBody MultipleMailRequest multipleMailRequest){
        streamBridge.send("sendMultiple",multipleMailRequest);
        return ResponseEntity.ok("Message sent !!!");
    }
}
