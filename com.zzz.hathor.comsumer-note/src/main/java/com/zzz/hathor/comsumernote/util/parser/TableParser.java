package com.zzz.hathor.comsumernote.util.parser;

import java.io.IOException;
import java.io.Reader;

public interface TableParser {
    public TableNode parseTable(Reader reader) throws IOException;
}
