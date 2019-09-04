package com.kafka.springbootkafkaproducer.model;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
public class User {

    @NotNull
    private String name;
    @NotNull
    private String dept;
    @NotNull
    @Min(10L)
    private Long salary;
}
