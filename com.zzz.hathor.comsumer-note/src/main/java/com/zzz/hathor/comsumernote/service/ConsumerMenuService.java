package com.zzz.hathor.comsumernote.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/menu")
public interface ConsumerMenuService {
    @GetMapping(value="/query")
    List<String> queryComsumerMenus();

}
