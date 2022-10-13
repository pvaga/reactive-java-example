package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

/**
 * @author prava
 *
 * Mono can return 0 OR 1 item
 */
public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
    	ReactiveSources.intNumberMono().subscribe(e -> System.out.println(e));
    	
    	//With error Consumer & Complete Consumer
    	ReactiveSources.intNumberMono().subscribe(
    			e -> System.out.println(e),
    			err -> System.out.println(err.getMessage()),
    			() -> System.out.println("Complete")
    		);

        // Get the value from the Mono into an integer variable
    	//Block the mono to get value
    	Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();
    	System.out.println(number.get());
    	
    	ReactiveSources.userMono().subscribe(u -> System.out.println(u.getFirstName()));

        System.out.println("Press a key to end");
        System.in.read();
    }
}
