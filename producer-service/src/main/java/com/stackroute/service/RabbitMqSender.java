package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${app.rabbitmq.exchange}")
    String exchange;

    @Value("${app.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employee) {
        rabbitTemplate.convertAndSend(exchange, routingkey, employee);
    }
}
