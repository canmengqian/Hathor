package com.zzz.hathor.codemaker.util;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class StringUtil<K,V> {
    public    String extract(HashMap<K, V> map) {
        Function<HashMap<K,V>,String> function = cols->{
            StringBuilder builder = new StringBuilder();
            cols.forEach((key,value)->{
                String field = new String();
               V v  = Optional.ofNullable(value).orElse((V) "");
               field= field.concat(key.toString()).concat("&").concat(v.toString());
                builder.append(field);
                builder.append("|");

            });
            return builder.toString().substring(0,builder.length()-1);
        };
        return function.apply(map);
    }
}
