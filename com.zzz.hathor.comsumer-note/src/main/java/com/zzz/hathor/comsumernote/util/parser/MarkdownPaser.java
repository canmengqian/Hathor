package com.zzz.hathor.comsumernote.util.parser;

import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownPaser implements  TableParser {

    private static  final String MARKDOWN_TABLE_DELIMETER="|";
    private static  final String MARKDOWN_TABLE_DELIMETER_ESCAPE="\\|";
    public static final  MarkdownPaser paser = new MarkdownPaser();
    private static  volatile int HEAD_NUM=1 ;

    @Override
    public TableNode parseTable(Reader reader)   {
        TableNode tableNode = new TableNode();
            ArrayList body=null;
        try{
            Node node = Parser.builder().build().parseReader(reader);
            Node child =node.getFirstChild();
            while (child != null) {
            if(child instanceof Paragraph) {
                Node text =  child.getFirstChild();
                while (text!=null) {
                    if(text instanceof Text) {
                        String str = text.toString();
                        str=foundRangeString(str);
                        if(HEAD_NUM==1) {
                            tableNode.setHead(assemberHead(str));
                            HEAD_NUM=0;
                            body= new ArrayList();
                        }else{
                            tableNode.setBody(assemberBody(body,str));
                        }

                    }
                   text= text.getNext();
                }
            }
            child = child.getNext();
        }
        return tableNode;
        }catch (IOException e) {
            clear();
            e.printStackTrace();
        }finally {
            clear();
        }
        return tableNode;
    }

    public String foundRangeString(String str) {
        int firstposition = str.indexOf(MARKDOWN_TABLE_DELIMETER,1);
        int lastposition = str.lastIndexOf(MARKDOWN_TABLE_DELIMETER);
       return str.substring(firstposition+1,lastposition).replaceAll(" ","");
    }

    private List<String> assemberHead(String str) {
       return  Arrays.asList(str.split(MARKDOWN_TABLE_DELIMETER_ESCAPE));
    }

    private List<String[]> assemberBody(List body,String str) {
     body.add(str.split(MARKDOWN_TABLE_DELIMETER_ESCAPE));
     return body;
    }

    private void clear() {
        HEAD_NUM=1;
    }


    public static void main(String[] args) throws IOException {
        File file = new File("E:\\life\\生活\\月度收支记录\\202010消费记录.md");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

        TableNode node = MarkdownPaser.paser.parseTable(br);
        node.getBody().stream().forEach(x->{
            System.out.println(x.length);
            String row=Arrays.asList(x).toString();
            System.out.println(row);
        });
    }
}
