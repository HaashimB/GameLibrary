package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GameServiceIF;

@RestController
public class GameController {

    @Autowired
    private GameServiceIF gameService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Game greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return greetingsManager.getGreeting();
    }
}