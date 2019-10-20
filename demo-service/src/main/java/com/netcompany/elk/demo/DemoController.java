package com.netcompany.elk.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {

    @PostMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello from the demo service", new Date());
    }
}
