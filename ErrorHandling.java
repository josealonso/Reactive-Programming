public class ErrorHandling {

    public static void main(String[] args) {

        /*
         * The DEFAULT behavior is to stop the request when an error happens.
         * In other words, the error is by default a terminal event.
         */

        // Print the value from intNumberFluxWithException() and print a message when
        // error happens
        ReactiveSources.intNumberFluxWithException()
                .subscribe(num -> System.out.println(num),
                        error -> System.out.println("Error happened"));

        // Print the value from intNumberFluxWithException() and print a message when
        // error happens
        ReactiveSources.intNumberFluxWithException()
                .doOnError(e -> System.out.println("Error !! " + e.getMessage()))
                .subscribe(num -> System.out.println(num));

        // Print values from intNumberFluxWithException() and continue on errors
        // (ignore the error)
        ReactiveSources.intNumberFluxWithException()
                .onErrorContinue((e, item) -> System.out.println("Error !! " + e.getMessage()))
                .subscribe(num -> System.out.println(num));

        // Print values from intNumberFluxWithException() and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumberFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
