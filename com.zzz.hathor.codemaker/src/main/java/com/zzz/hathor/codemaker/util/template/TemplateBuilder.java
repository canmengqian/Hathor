package com.zzz.hathor.codemaker.util.template;

import java.io.InputStream;
import java.io.Reader;

public interface TemplateBuilder<T,R> {
    public R onBuild(T config, InputStream inputStream);

    public R onBuild(T config, Reader reader);


}
