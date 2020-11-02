package com.zzz.hathor.comsumernote;

import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.junit.jupiter.api.Test;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ToHtmlSerializer;
import org.pegdown.ast.Visitor;

import java.io.*;
import java.util.List;

public class MarkDownTest {
    @Test
    public void testParseMkDwonTable() throws IOException {

       // Parser parser = new Parser(Parser.ALL_OPTIONALS,30000L, Parser.DefaultParseRunnerProvider);
      /*  PegDownProcessor pegDownProcessor = new PegDownProcessor();
        Visitor visitor = new ToHtmlSerializer(new LinkRenderer());

                String line = null;
        String mdContent = "";
        while ((line = br.readLine()) != null) {
            mdContent += line;
        }
        System.out.println(mdContent);*/

    }
}
