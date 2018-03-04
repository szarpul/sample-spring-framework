package com.szarpcode.samples.spring.config;

import com.szarpcode.samples.spring.beans.ExtendedHelloMessageProducer;
import com.szarpcode.samples.spring.beans.MessageProducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJavaConfig {

    @Bean
    public MessageProducer helloMessageProducer() {
        ExtendedHelloMessageProducer messageProducer = new ExtendedHelloMessageProducer();
        messageProducer.setName("mate");
        return messageProducer;
    }
}
