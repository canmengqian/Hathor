package com.zzz.hathor.cloud.test.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ClientController {
    @Value("${name}")
    private String name;
    @RequestMapping("/hello")
    public String index() {
        return this.name;
    }
}
