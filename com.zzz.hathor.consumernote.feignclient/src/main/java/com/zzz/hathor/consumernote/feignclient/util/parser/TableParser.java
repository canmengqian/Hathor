package com.zzz.hathor.consumernote.feignclient.util.parser;

import java.io.IOException;
import java.io.Reader;

public interface TableParser {
    public TableNode parseTable(Reader reader) throws IOException;
}
