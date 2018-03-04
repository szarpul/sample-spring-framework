package com.szarpcode.samples.spring.beans;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeMessageProducer implements MessageProducer {

    private List<? extends MessageProducer> messageProducers = new ArrayList<>();

    @Override
    public String getMessage() {

        return messageProducers
                .stream()
                .map(MessageProducer::getMessage)
                .collect(Collectors.joining("\n"));
    }

    public List<? extends MessageProducer> getMessageProducers() {
        return messageProducers;
    }

    public void setMessageProducers(List<? extends MessageProducer> messageProducers) {
        this.messageProducers = messageProducers;
    }

    public void addMessageProducer(MessageProducer messageProducer){
        this.addHelper(messageProducers, messageProducer);
    }

    private <T extends MessageProducer> void addHelper(List<T> list, MessageProducer messageProducer) {
        list.add((T) messageProducer);
    }
}
