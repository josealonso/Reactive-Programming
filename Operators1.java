public class Operators1 {

    public static void main(String[] args) {

        //// IMPORTANT !!
        // The "subscribe" method triggers the request, so it's mandatory.

        /* O P E R A T O R S */

        // Print all values from intNumberFlux that's greater than 5.
        ReactiveSources.intNumberFlux()
                .log()
                .filter(e -> e > 5)
                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumberFlux that's greater than 5.
        ReactiveSources.intNumberFlux()
                .filter(e -> e > 5)
                .map(e -> 10 * e)
                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumberFlux that's greater than 5
        // only for the first three numbers.
        ReactiveSources.intNumberFlux()
                .filter(e -> e > 5)
                .map(e -> 10 * e)
                .take(3) // and limit ?
                .subscribe(System.out::println);

        // Print each value from intNumberFlux that's greater than 20.
        // Print -1 if no elements are found.
        ReactiveSources.intNumberFlux()
                .filter(e -> e > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumberFlux to the right user from userFlux
        ReactiveSources.intNumberFlux()
                .flatMap(id -> ReactiveSources.userFlux())
                .filter(user -> user.getId() == id)
                .take(1)
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumberFluxWithRepeat
        ReactiveSources.intNumberFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumberFluxWithRepeat excluding
        // immediately repeating numbers.
        ReactiveSources.intNumberFluxWithRepeat()
                .distinctUntilChanged()
                .log()
                .subscribe(System.out::println);

        // 
        

        System.out.println("Press a key to end");
        System.in.read();
    }

    // For both Flux and Mono, a failure event is a terminal event

}
