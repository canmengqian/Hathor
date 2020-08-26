package com.zzz.hathor.captcha.webflux.handler;

import com.zzz.hathor.captcha.webflux.domain.bean.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @ClassName UserHandler
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/25 18:46
 * @Version 1.0.0
 **/
@RestController
public class UserHandler {



    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.OK) .body(Mono.just(User.builder().age("24").name("zhangsan").build()),User.class);
    }


    /*public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        printlnThread("获取所有用户");
        Flux<User> userFlux = Flux.fromStream(userRepository.getUsers().entrySet().stream().map(Map.Entry::getValue));
        return ServerResponse.ok()
                .body(userFlux, User.class);
    }*/
    /**
     * 打印当前线程
     * @param object
     */
    private void printlnThread(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }
}