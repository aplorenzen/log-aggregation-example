package com.netcompany.elk.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class DemoController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        log.info("Request for hello received, sending response");
        return new HelloResponse("Hello from the demo service", new Date());
    }
}
