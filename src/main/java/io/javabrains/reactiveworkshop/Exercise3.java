package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prava
 * 
 * Flux can return 0 OR N item
 *
 */
public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
    	//Blocks till it gets all elements
        List<Integer> numbers = ReactiveSources.intNumbersFlux()
        							.toStream()
        							.collect(Collectors.toList());
        
        System.out.println("List is: "+numbers);
        System.out.println("List Size is: "+numbers.size());
        
        
        System.out.println("*****With Error & Complete Consumer*******");
        
        ReactiveSources.intNumbersFlux().subscribe(
    			e -> System.out.println(e),
    			err -> System.out.println(err.getMessage()),
    			() -> System.out.println("Complete")
    	);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
