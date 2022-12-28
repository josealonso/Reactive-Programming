public class Exercise1 {

    public static void main(String[] args) {

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono()
                .subscribe(number -> System.out.println());

        // Get the value from the Mono into an integer variable
        // Blocking should be avoided
        User foo = ReactiveSources.userMono().block();

        System.out.println("Press a key to end");
        System.in.read();
    }

    // For both Flux and Mono, a failure event is a terminal event
    
}