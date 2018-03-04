package com.szarpcode.samples.spring.beans;


public class WelcomeMessageProducer implements MessageProducer {

    private String suffix;

    public WelcomeMessageProducer() {
    }

    public WelcomeMessageProducer(String suffix) {
        this.suffix = suffix;
    }

    public static WelcomeMessageProducer create(){
        return new WelcomeMessageProducer("mate");
    }

    @Override
    public String getMessage() {
        return String.format("Welcome %s!", suffix);
    }
}
