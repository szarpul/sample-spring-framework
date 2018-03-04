package com.szarpcode.samples.spring;


import com.szarpcode.samples.spring.beans.MessageService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;

import static com.szarpcode.samples.spring.ContextFactory.ContextType;
import static com.szarpcode.samples.spring.ContextFactory.ContextType.JAVA_CONFIG;

public class Main {

    public static void main(String[] args) {

//        ContextType contextType = CLASS_PATH_XML;
//        ContextType contextType = GENERIC;
        ContextType contextType = JAVA_CONFIG;

        ApplicationContext applicationContext = new ContextFactory()
                .create(contextType);

        ((Lifecycle) applicationContext).start();
        ((Lifecycle) applicationContext).stop();

        MessageService messageService = applicationContext.getBean(MessageService.class);

        System.out.println(messageService.getMessage());

    }
}
