package com.szarpcode.samples.spring.beans;

import java.util.UUID;

public class RandomStringMessageProducer implements MessageProducer {

    private final String id;

    public RandomStringMessageProducer(){
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getMessage() {
        return "Hello, I'm a prototype. My id is: " + id;
    }
}
