package com.netcompany.elk.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class ProviderController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        log.info("Request for hello received, sending response");
        return new HelloResponse("Hello from the demo service", new Date());
    }
}
