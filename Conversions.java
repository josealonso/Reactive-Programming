public class Conversions {

        public static void main(String[] args) {

                /*
                 * Conversions between Flux and Mono
                 */

                // Print size of intNumberFlux after the last item returns
                ReactiveSources.intNumberFlux()
                                .count()
                                .subscribe(System.out::println);

                // Collect all items of intNumberFlux into a single list and print it
                ReactiveSources.intNumberFlux()
                                .collectList()
                                .subscribe(System.out::println);

                // Transform a sequence of sums of adjacent two numbers
                ReactiveSources.intNumberFlux()
                                .buffer(2)
                                .map(list -> list.get(0) + list.get(1))
                                .subscribe(System.out::println);

                System.out.println("Press a key to end");
                System.in.read();
        }

}
