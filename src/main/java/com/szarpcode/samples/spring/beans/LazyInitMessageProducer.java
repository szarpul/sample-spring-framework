package com.szarpcode.samples.spring.beans;


import java.time.LocalTime;

public class LazyInitMessageProducer implements MessageProducer {

    LocalTime localTime = LocalTime.now();


    @Override
    public String getMessage() {
        return "This is lazy bean. I have been instantiated at: " + localTime.toString();
    }
}
