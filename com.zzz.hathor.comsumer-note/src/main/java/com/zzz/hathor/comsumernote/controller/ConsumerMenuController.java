package com.zzz.hathor.comsumernote.controller;

import com.zzz.hathor.comsumernote.service.ConsumerMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ConsumerMenuController implements ConsumerMenuService {
    @Override
    public List queryComsumerMenus() {
        log.error("consumer - provider");
        return new ArrayList();
    }
}
