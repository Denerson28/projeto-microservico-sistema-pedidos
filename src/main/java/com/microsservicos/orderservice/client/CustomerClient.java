package com.microsservicos.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomerClient {

    private final WebClient webClient = WebClient.create("http://localhost:8081"); // mock do customer-service

    public boolean isCustomerValid(Long customerId) {
        try {
            return webClient.get()
                    .uri("/api/customers/{id}", customerId)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .map(x -> true)
                    .onErrorReturn(false)
                    .block();
        } catch (Exception e) {
            return false;
        }
    }
}
