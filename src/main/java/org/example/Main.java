package org.example;

import org.example.event.MyEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);

        int m = randomNumber();
        int i;

        publisher.publisherEvent(context.getMessage("hello", null, Locale.getDefault()));

        do {
            int number = new Scanner(System.in).nextInt();
            i = number;

            if ( m == i) {
                publisher.publisherEvent(context.getMessage("win", new Object[] {m}, Locale.getDefault()));
            } else if (m < i) {
                publisher.publisherEvent(context.getMessage("upper", null, Locale.getDefault()));
            } else if (m > i) {
                publisher.publisherEvent(context.getMessage("lower", null, Locale.getDefault()));
            }
        } while (m < i || m > i);
    }

    public static int randomNumber() {
        int number = new Random().nextInt(1001);
        System.out.println("я загадал " + number);
        return number;
    }
}
