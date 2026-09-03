package com.fitness.activityservice.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced

    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
     @Bean
    public WebClient userServiceWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl("http://USER-SERVICE")
                .build();

    }
    //“Use Spring Cloud’s load-balancing mechanism when resolving service
    //Eureka = Service Discovery
    //@LoadBalanced = Connects your HTTP client to that load-balancing mechanism






}
