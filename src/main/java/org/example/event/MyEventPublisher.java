package org.example.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public String publisherEvent(String eventData) {
        context.publishEvent(new MyEvent(eventData));
        return eventData;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
