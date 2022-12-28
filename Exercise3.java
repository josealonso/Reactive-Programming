import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String but give up after 5 seconds
        String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Netty is very efficient, beause it's a reactive non-blocking application server
        // It's a very good choice for reactive programming
        // It's used by Spring WebFlux
        // It's used by Vert.x
        // It's used by Akka HTTP
        // It's used by Play Framework
        // It's used by Ratpack
        // It's used by Spring Cloud Gateway
        

        // Get the value from the Mono into an integer variable
        // Blocking should be avoided
        User foo = ReactiveSources.userMono().block();

        System.out.println("Press a key to end");
        System.in.read();
    }

    // For both Flux and Mono, a failure event is a terminal event

}