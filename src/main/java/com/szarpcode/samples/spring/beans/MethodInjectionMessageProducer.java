package com.szarpcode.samples.spring.beans;


public abstract class MethodInjectionMessageProducer implements MessageProducer {

    public void init() {
        System.out.println("Initializing " + MethodInjectionMessageProducer.class.getSimpleName() + " bean.");
    }


    @Override
    public String getMessage() {
        return "Message from producer injected by method injection: " + createMessageProducer().getMessage();
    }

    public abstract MessageProducer createMessageProducer();
}
