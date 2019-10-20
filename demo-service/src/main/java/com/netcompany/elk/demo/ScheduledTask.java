package com.netcompany.elk.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ScheduledTask {

    // @Scheduled(fixedRate = 1000L)
    public void logSomething() {
        Map<String, String> env = System.getenv();
        env.forEach((key, value) -> {
            log.info("{} = {}", key, value);
        });

    }
}
