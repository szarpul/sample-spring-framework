package com.szarpcode.samples.spring.beans;

public class ExtendedHelloMessageProducer extends HelloMessageProducer {

    @Override
    public String getMessage() {
        return "Hello from extended message producer: " + super.getMessage();
    }
}
