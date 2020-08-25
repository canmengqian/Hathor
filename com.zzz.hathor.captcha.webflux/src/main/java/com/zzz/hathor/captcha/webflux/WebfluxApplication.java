package com.zzz.hathor.captcha.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.io.IOException;

@SpringBootApplication
public class WebfluxApplication {

    public static void main(String[] args) throws IOException {
         SpringApplication.run(WebfluxApplication.class, args);
    }

}
