package com.matovic.consumer;

import com.matovic.producer.CustomMessage;
import com.matovic.producer.MQConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @RabbitListener(queues = MQConfiguration.QUEUE)
    public void listener(CustomMessage message) {
        log.info("Message received: {} ", message);
    }
}
