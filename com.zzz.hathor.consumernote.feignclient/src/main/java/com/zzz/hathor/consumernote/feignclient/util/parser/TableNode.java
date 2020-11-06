package com.zzz.hathor.consumernote.feignclient.util.parser;

import lombok.Data;

import java.util.List;
@Data
public class TableNode {
    public List<String> head;
    public List<String[]> body;

}
