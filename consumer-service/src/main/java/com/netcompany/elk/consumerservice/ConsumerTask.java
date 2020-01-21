package com.netcompany.elk.consumerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ConsumerTask {

    @Scheduled(fixedDelay = 250L)
    public void sayHello() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HelloResponse helloResponse = restTemplate.getForObject("http://provider-service/hello", HelloResponse.class);
            log.info("Received response: {}", helloResponse);
        } catch (RestClientException e) {
            log.error("Unable to get response for a polite hello, how rude!", e);
        }
    }
}
