package com.theara.springbootrabbitmqexample.service;

import com.theara.springbootrabbitmqexample.model.dto.MailRequest;
import com.theara.springbootrabbitmqexample.model.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RabbitMQJsonProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.routing.mail.key}")
    private String mailRoutingKey;
    public void sendJsonMessage(User user) {
        log.info(String.format("Message send -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }

    public void sendMail(MailRequest mailRequest) {
        log.info(String.format("Message send -> %s", mailRequest.toString()));
        rabbitTemplate.convertAndSend(exchange, mailRoutingKey, mailRequest);
    }
}
