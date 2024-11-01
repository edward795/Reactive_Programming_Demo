package org.example.subscriber;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.*;


public class SubscriberImpl implements Subscriber<String> {
    private static final Logger LOGGER= LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription s) {
      this.subscription=s;
    }

    @Override
    public void onNext(String email) {
        LOGGER.info("received: {}",email);
        System.out.println("received : "+email);
    }

    @Override
    public void onError(Throwable t) {
        LOGGER.error("received: {}",t);
    }

    @Override
    public void onComplete() {
        LOGGER.info("completed");
    }
}
