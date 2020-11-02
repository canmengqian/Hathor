package com.zzz.hathor.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {

        // java -javaagent:D:\softlist\skywalking\apache-skywalking-apm-bin\agent\skywalking-agent.jar -jar eurekaserver-0.0.1-SNAPSHOT.jar


        SpringApplication.run(Application.class, args);
    }

}
