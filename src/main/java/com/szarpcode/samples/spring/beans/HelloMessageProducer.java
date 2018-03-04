package com.szarpcode.samples.spring.beans;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloMessageProducer implements MessageProducer {

    private String name = "";

    @PostConstruct
    public void customInit() {
        System.out.println("Initializing " + HelloMessageProducer.class.getSimpleName() + " bean in a custom way.");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Destroying " + HelloMessageProducer.class.getSimpleName() + " bean.");
    }

    @Override
    public String getMessage() {
        return String.format("Hello %s!", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
