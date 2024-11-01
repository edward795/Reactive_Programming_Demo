package org.example.StreamLazyBehaviour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class LazyBehaviour {
    public  static Logger LOGGER= LoggerFactory.getLogger(LazyBehaviour.class);
    public static void main(String[] args) {
        Stream.of(1)
                .peek(i->LOGGER.info("received {}",i));
//                .toList();
    }
}
