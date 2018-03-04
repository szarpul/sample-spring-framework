package com.szarpcode.samples.spring.beans;


import java.util.Properties;

public class PropsMessageProducer implements MessageProducer {

    private Properties properties;


    @Override
    public String getMessage() {
        return properties.toString();
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
