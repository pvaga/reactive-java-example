package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
    	/*ReactiveSources.intNumbersFlux().subscribe(
     			e -> System.out.println(e),
     			err -> System.out.println(err.getMessage()),
     			() -> System.out.println("Complete")
     	);
    	 
    	ReactiveSources.userMono().subscribe(
    			 u -> System.out.println(u.getFirstName()),
    			 err ->  System.out.println(err.getMessage()),
    			 () -> System.out.println("Complete")
    		);*/

        // Subscribe to a flux using an implementation of BaseSubscriber
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<Integer>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {
	
	public void hookOnSubscribe(Subscription subscription) {
		 System.out.println("Subscriber Happenned");
		 request(1);
	}
	
	public void hookOnNext(T value) {
		 System.out.println(value.toString() +" received");
		 request(2);
	}
}