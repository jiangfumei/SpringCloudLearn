package com.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

/*    private static final Logger LOG = LoggerFactory.getLogger(ZipkinApplication.class);

    @Resource
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome(){
        LOG.info("calling trace zipkin  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        LOG.info("calling trace zipkin ");

        return "i'm service-hi";

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }*/


    /*private LoadBalancerExchangeFilterFunction lbFunction;*/
    @Resource
    WebClient webClient;


/*    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public ZipkinApplication(WebClient.Builder webClientBuilder,
                           ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.lbFunction = lbFunction;
    }*/
    /*public WebClient webClient() {
        return webClient..baseUrl("http://service-myya")
                .filter(lbFunction)
                .build();
    }*/

    @GetMapping("/trace-a")
    public Mono<String> trace() {
        System.out.println("===call trace-a===");

        return webClient.get()
                .uri("http://service-myya/trace-b")
                .retrieve()
                .bodyToMono(String.class);
    }

}
