package Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * It will not work as the controller is in different package
 * It should be in main package
 */
@RestController
public class SecondController {
    @GetMapping("/2/hi")
    public String sayHello() {
        return "Hi there, How you doin";
    }
}
