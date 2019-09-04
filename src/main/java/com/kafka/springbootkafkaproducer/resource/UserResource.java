package com.kafka.springbootkafkaproducer.resource;

import com.kafka.springbootkafkaproducer.model.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("kafka")
public class UserResource {

    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Hello-Kafka";

    @PostMapping("/messages")
    public String post(@Valid @RequestBody User user) {

        kafkaTemplate.send(TOPIC, user);

        return "Published successfully";
    }
}
