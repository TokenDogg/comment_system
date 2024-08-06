package com.tokendogg.comment_system.config;

import org.springframework.amqp.core.*;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "likes.exchange";

    @Bean
    public Channel rabbitChannel() throws IOException, TimeoutException {
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.newConnection();
        Channel ch = conn.createChannel(1);
        ch.exchangeDeclare(EXCHANGE_NAME,"direct");

        return ch;
    }

}
