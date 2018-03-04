package com.szarpcode.samples.spring.beans;


public class MessageService {

    private String version;
    private MessageProducer messageProducer;

    public MessageService(String version) {
        this.version = version;
    }

    public String getMessage() {
        return String.format(
                "Message from MessageService %s: %s",
                version, messageProducer.getMessage());
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
}
