package com.zzz.hathor.codemaker.util;

import java.util.function.Function;

public interface StringTokenizer {

    public String extract(Function<Object,String> function );

}
