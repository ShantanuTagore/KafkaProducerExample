package com.kafka.springboot.resource;

import com.kafka.springboot.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log
@RestController
@AllArgsConstructor
@RequestMapping("kafka")
public class UserResource {

    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Hello-Kafka";

    @PostMapping("/messages")
    public String post(@Valid @RequestBody User user) {

        kafkaTemplate.send(TOPIC, user);
        log.info("Published successfully");

        return "Published successfully";
    }
}
