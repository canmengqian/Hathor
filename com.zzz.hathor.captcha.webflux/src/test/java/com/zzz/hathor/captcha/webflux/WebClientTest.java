package com.zzz.hathor.captcha.webflux;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @ClassName WebClientTest
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/26 9:42
 * @Version 1.0.0
 **/
public class WebClientTest {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("http://localhost:8007/mono").retrieve().bodyToMono(String.class);
        System.out.println(mono.block());
    }
}
