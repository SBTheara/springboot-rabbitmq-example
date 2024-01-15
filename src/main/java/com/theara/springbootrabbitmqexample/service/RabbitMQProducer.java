package com.theara.springbootrabbitmqexample.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.stream.ConfirmationStatus;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.Producer;
import com.theara.springbootrabbitmqexample.model.dto.MailRequest;
import com.theara.springbootrabbitmqexample.model.dto.MultipleMailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    Environment environment = Environment.builder()
            .uri("rabbitmq-stream://guest:guest@localhost:5552")
            .build();

    public void sendMessageWithoutAttachment(MailRequest message) throws JsonProcessingException {
        log.info(String.format("Message send -> %s", message));
        this.producerPrepare(message);
    }
    public void sendMessageWithAttachment(MailRequest message) throws JsonProcessingException {
        log.info(String.format("Message send -> %s", message));
        this.producerPrepare(message);
    }

    private void producerPrepare(MailRequest message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String stream = "my-stream";
        environment.streamCreator().stream(stream).create();
        Producer producer = environment.producerBuilder()
                .stream(stream)
                .build();
        Message message1 = producer.messageBuilder()
                .properties()
                .messageId(UUID.randomUUID().toString())
                .messageBuilder()
                .addData(mapper.writeValueAsBytes(message)).build();
        producer.send(message1, ConfirmationStatus::isConfirmed);
    }

    public void sendMessageWithoutAttachment(MultipleMailRequest message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String stream = "my-stream-without-attachment";
        Producer producer = environment.producerBuilder()
                .stream(stream)
                .build();
        Message message1 = producer.messageBuilder()
                .properties()
                .messageId(UUID.randomUUID())
                .correlationId(UUID.randomUUID())
                .messageBuilder()
                .addData(mapper.writeValueAsBytes(message)).build();
        producer.send(message1, ConfirmationStatus::isConfirmed);
    }


}
