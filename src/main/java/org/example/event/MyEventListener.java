package org.example.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getData());
    }
}
