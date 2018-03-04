package com.szarpcode.samples.spring.config;

import com.szarpcode.samples.spring.beans.CompositeMessageProducer;
import com.szarpcode.samples.spring.beans.HelloMessageProducer;
import com.szarpcode.samples.spring.beans.LazyInitMessageProducer;
import com.szarpcode.samples.spring.beans.MessageProducer;
import com.szarpcode.samples.spring.beans.MessageService;

import org.springframework.context.annotation.*;

@Configuration
public class DefaultConfig {


    @Bean
    public MessageService messageService() {
        MessageService messageService = new MessageService("java_config:1.0.0");
        messageService.setMessageProducer(compositeMessageProducer());
        return messageService;
    }

    @Bean
    public MessageProducer compositeMessageProducer() {
        CompositeMessageProducer messageProducer = new CompositeMessageProducer();
        messageProducer.addMessageProducer(helloMessageProducer());
        messageProducer.addMessageProducer(lazyMessageProducer());
        return messageProducer;
    }

    @Bean
    public MessageProducer helloMessageProducer() {
        HelloMessageProducer messageProducer = new HelloMessageProducer();
        messageProducer.setName("mate");
        return messageProducer;
    }

    @Bean
    @Lazy
    public MessageProducer lazyMessageProducer() {
        return new LazyInitMessageProducer();
    }
}
