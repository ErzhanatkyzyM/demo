package springboot.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.token.TokenGenerator;

@RestController
public class TokenController {

    @GetMapping("/generate-token")
    public String generateToken() {
        return TokenGenerator.generateToken();
    }


}
