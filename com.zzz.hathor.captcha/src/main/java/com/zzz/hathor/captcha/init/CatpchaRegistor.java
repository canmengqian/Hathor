package com.zzz.hathor.captcha.init;

import com.google.code.kaptcha.util.Config;

import java.util.HashMap;

public class CatpchaRegistor {
    private  HashMap<String,Object> produces ;

    private Config config;
    public CatpchaRegistor(Config config) {
        this.config = config;
    }

    public static void init() {
       /* config.getProducerImpl();
        config.getTextProducerImpl();
        config.getNoiseImpl();
        config.*/
    }
}
