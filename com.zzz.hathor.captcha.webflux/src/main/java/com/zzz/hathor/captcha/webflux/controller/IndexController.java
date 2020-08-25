package com.zzz.hathor.captcha.webflux.controller;

import com.zzz.hathor.captcha.webflux.domain.bean.User;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/25 16:26
 * @Version 1.0.0
 **/
@RestController
public class IndexController {
    @GetMapping("/mono")
    public Mono<User> index() {
        return Mono.just(User.builder().age("24").name("zhangsan").build());
    }

    @GetMapping("/flux")
    public Flux<User> flux() {
        return Flux.just(User.builder().age("24").name("zhangsan").build());
    }
}
