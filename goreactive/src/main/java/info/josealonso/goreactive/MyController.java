package info.josealonso.goreactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetingMessage() {
        return computeMessage()
                .zipWith(getNameFromDB())
                .map(value -> {
                    return value.getT1() + value.getT2();
                });
    }

    private Mono<String> computeMessage() {
        return Mono.just("Hello ");
    }

    private Mono<String> getNameFromDB() {
        return Mono.just("John").delayElement(Duration.ofSeconds(5));
    }

}
