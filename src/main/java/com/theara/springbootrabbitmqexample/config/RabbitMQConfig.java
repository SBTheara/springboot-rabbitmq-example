package com.theara.springbootrabbitmqexample.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    @Value("${rabbitmq.queue.mail.name}")
    private String mailQueue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.routing.mail.key}")
    private String mailRoutingKey;

    //spring bean for rabbitmq queue

//    @Bean
//    public Queue queue() {
//        return new Queue(queue,false);
//    }
//
//    @Bean
//    public Queue jsonQueue() {
//        return new Queue(jsonQueue,false);
//    }
//
//    @Bean
//    public Queue mailQueue() {
//        return new Queue(queue,false);
//    }
//
//    //spring bean for rabbitmq exchange
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange(exchange);
//    }
//
//    //Binding between queue and exchange using routing key
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
//    }
//
//    @Bean
//    public Binding jsonBinding() {
//        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(jsonRoutingKey);
//    }
//
//    @Bean
//    public Binding mailBinding() {
//        return BindingBuilder.bind(mailQueue()).to(exchange()).with(mailRoutingKey);
//    }
//    @Bean
//    public MessageConverter converter(){
//        return new Jackson2JsonMessageConverter();
//    }

//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        System.out.println("rmqhost is localhost");
//        factory.setHost("localhost");
//        factory.setVirtualHost("localhost");
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        factory.setPort(5672);
//        return factory;
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin() {
//        return new RabbitAdmin(connectionFactory());
//    }

//    @Bean
//    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(converter());
//        return rabbitTemplate;
//    }


    //ConnectionFactory
    //RabbitTemplate
    //RabbitAdmin

    //spring boot automatic create these three bean for us , so we've no need to create these beans


}
