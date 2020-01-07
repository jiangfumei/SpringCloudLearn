package com.sleuth.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

@Configuration
@LoadBalancerClient(name = "say-hello", configuration = ZipkinApplication.class)
public class WebClientConfig {

    @Autowired
    LoadBalancerExchangeFilterFunction lbFunction;

    @LoadBalanced
    @Bean
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .filter(lbFunction)
                .build();
    }


}
