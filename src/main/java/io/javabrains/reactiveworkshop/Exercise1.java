package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
    	//Can't keep reference of stream requires fresh stream for each time.
    	//Stream<Integer> intStream = StreamSources.intNumbersStream();
    	//Stream<User> userStream = StreamSources.userStream();

        // Print all numbers in the intNumbersStream stream
    	StreamSources.intNumbersStream().forEach(i -> System.out.print(i+" "));

        // Print numbers from intNumbersStream that are less than 5
    	StreamSources.intNumbersStream().filter(number -> number<5).forEach(System.out::print);

        // Print the second and third numbers in intNumbersStream that's greater than 5
    	StreamSources.intNumbersStream().filter(number -> number<5)
    		.skip(1)
    		.limit(2)
    		.forEach(System.out::print);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
    	Integer value = StreamSources.intNumbersStream().filter(number -> number>5)
    		.findFirst()
    		.orElse(-1);
    	System.out.println(value);

        // Print first names of all users in userStream
    	StreamSources.userStream().forEach(u -> System.out.println(u.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
    	//Flatmap maps stream result to a stream to create flattened stream values
    	//Option1: Not recommended (Little buggy when no match)
    	System.out.println("*****Option1******");
    	StreamSources.intNumbersStream()
    		.flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
    		.forEach(user-> System.out.println(user.getId() +":"+user.getFirstName()));
    	
    	//Option2
    	System.out.println("*****Option2******");
    	StreamSources.userStream()
		.filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
		.forEach(user-> System.out.println(user.getId() +":"+user.getFirstName()));
     }
}