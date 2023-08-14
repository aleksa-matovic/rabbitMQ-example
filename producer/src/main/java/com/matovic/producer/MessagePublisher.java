package com.matovic.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;


@RestController
@Slf4j
@AllArgsConstructor
public class MessagePublisher {

    private final RabbitTemplate template;

    @PostMapping("/publish")
    public void publishMessage(@RequestBody CustomMessage message) {

        message.setMessageId(UUID.randomUUID().toString());
        message.setMessage(message.getMessage());
        message.setMessageDate(new Date());

        template.convertAndSend(MQConfiguration.EXCHANGE, MQConfiguration.ROUTING_KEY, message);

        log.info("Published message: {} ", message);

    }
}
