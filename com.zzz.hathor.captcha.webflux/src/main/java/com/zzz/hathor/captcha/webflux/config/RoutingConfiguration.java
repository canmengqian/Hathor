package com.zzz.hathor.captcha.webflux.config;

import com.zzz.hathor.captcha.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @ClassName RoutingConfiguration
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/25 18:44
 * @Version 1.0.0
 **/
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
        return  route(GET("/webflux/user/{userId}"), userHandler::getUserById);
    }
}
