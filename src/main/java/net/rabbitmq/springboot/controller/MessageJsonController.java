package net.rabbitmq.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import net.rabbitmq.springboot.dto.User;
import net.rabbitmq.springboot.publisher.RabbitMQJsonProducer;
import net.rabbitmq.springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        log.info("user 객체: {}", user);
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("RabbitMQ로 Json 메시지 보냄");
    }

}
