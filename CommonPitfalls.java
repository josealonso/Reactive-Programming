public class CommonPitfalls {

    public static void main(String[] args) {

        // 1.- Subscribe to the wrong flux (not chain the operators)
        Flux<Integer> flux = getFlux();
        flux.map(value -> value * 2);
        // Error --> we are subscribing to the original flux
        // and not the mapped one
        flux.subscribe(next -> System.out.println("Received: " + next));
        // Subscribe returns a Disposable, not a Flux.
    }

    private static Flux<Integer> getFlux() {
        return Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    // 2.- Do not use the "subscribe" method, which is the terminal operator
    // that triggers the flux.
}