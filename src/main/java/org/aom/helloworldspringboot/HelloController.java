package org.aom.helloworldspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${MESSAGE:Hello Default}")
    private String message;

    @Value("${APP_SECRET:default-secret}")
    private String appSecret;

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        //return helloService.getGreeting(name);
        return message;
    }

    @GetMapping("/secret")
    public String secret() {
        return appSecret;
    }
}
