package org.example.subscriber;

import org.example.publisher.PublisherImpl;
import org.slf4j.*;


import java.time.Duration;

public class Demo {
    private static Logger LOGGER= LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) throws InterruptedException {
        demo4();
        LOGGER.info("testing logger!!");
    }

    private static void demo1(){
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2() throws InterruptedException {
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(3));

    }

    private static void demo3() throws InterruptedException {
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(3);
    }

    private static void demo4() throws InterruptedException {
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(3);
    }
}
