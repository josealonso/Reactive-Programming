public class Exercise2 {

    public static void main(String[] args) {

        // Print the value from intNumberMono when it emits
        // Block A
        // ReactiveSources.intNumberFlux()
        //         .subscribe(
        //                 number -> System.out.println(number),
        //                 error -> System.out.println(error),
        //                 () -> System.out.println("Completed"));

        // Get the value from the Mono into an integer variable
        // Blocking should be avoided
        User foo = ReactiveSources.userMono().block();

        // Subscribe to a flux using on implementation of BaseSubscriber
        ReactiveSources.intNumberFlux()
                .subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }
}

// This is more powerful than Block A
class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + "received");
        request(1);
    }
}