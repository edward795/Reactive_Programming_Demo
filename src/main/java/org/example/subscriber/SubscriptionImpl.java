package org.example.subscriber;


import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final int MAX_ITEMS=10;
    private final Faker faker;

    private boolean isCancelled;
    private int count=0;
    private static final Logger LOGGER= LoggerFactory.getLogger(SubscriptionImpl.class);

    private Subscriber<? super String> subscriber;
    public SubscriptionImpl(Subscriber<? super String> subscriber){
        this.subscriber=subscriber;
        this.faker=Faker.instance();
    }
    @Override
    public void request(long requested) {
        if(isCancelled){
            return;
        }
        LOGGER.info("subscriber has requested {} items",requested);
        if(requested>MAX_ITEMS){
            this.subscriber.onError(new RuntimeException("Validation failed!!"));
            return;
        }
        for (int i=0;i<requested && count<MAX_ITEMS;i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count==MAX_ITEMS){
            LOGGER.info("no more data to produce");
            this.subscriber.onComplete();
            this.isCancelled=true;
        }
    }

    @Override
    public void cancel() {
        LOGGER.info("subscriber has cancelled");
        this.isCancelled=true;
    }
}
