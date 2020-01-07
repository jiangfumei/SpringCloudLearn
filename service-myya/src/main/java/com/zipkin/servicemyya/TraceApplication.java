package com.zipkin.servicemyya;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class TraceApplication {

/*    public Logger Log = LoggerFactory.getLogger(ServiceMyyaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceMyyaApplication.class, args);
    }

    @RequestMapping("/hi")
    public String home(){
        Log.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        Log.info("info is being called");
        return restTemplate.getForObject("http://localhost:2999/info",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }*/


    @GetMapping("/trace-b")
    public Mono<String> trace() {
        System.out.println("===call trace-b===");

        return Mono.just("Trace");
    }
}
