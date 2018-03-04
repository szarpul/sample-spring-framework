package com.szarpcode.samples.spring;


import com.szarpcode.samples.spring.config.CustomJavaConfig;
import com.szarpcode.samples.spring.config.DefaultConfig;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ContextFactory {

    public static final String[] CONTEXT_CONFIG_LOCATION_DEFAULT = {"service-context.xml"};

    public enum ContextType {GENERIC, CLASS_PATH_XML, JAVA_CONFIG}
    private String[] contextConfigLocations = CONTEXT_CONFIG_LOCATION_DEFAULT;

    public ApplicationContext create(ContextType contextType) {

        switch (contextType) {
            case CLASS_PATH_XML:
                return createClassPathXmlApplicationContext();
            case GENERIC:
                return createGenericApplicationContext();
            case JAVA_CONFIG:
                return createJavaConfigApplicationContext();
            default:
                throw new IllegalArgumentException("Context type: " + contextType + " not supported.");
        }
    }

    private ApplicationContext createJavaConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // beans from custom config will override those from default,
        // because they registered as a second bean.
        context.register(DefaultConfig.class);
        context.register(CustomJavaConfig.class);

        context.refresh();
        return context;
    }

    private ApplicationContext createGenericApplicationContext() {
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("service-context.xml");
        genericApplicationContext.refresh();
        return genericApplicationContext;
    }

    private ApplicationContext createClassPathXmlApplicationContext() {
        return new ClassPathXmlApplicationContext(this.contextConfigLocations);
    }

    public ContextFactory withContext(String... contextConfigLocations) {
        this.contextConfigLocations = contextConfigLocations;
        return this;
    }

}
