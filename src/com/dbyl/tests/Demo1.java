package com.dbyl.tests;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dbyl.libarary.utils.StringTools;

public class Demo1
{

    public static void main(String[] args) throws IOException
    {
    	String a=StringTools.getMatchGroup("http://www.baidu.com", "\\.(\\w{1,5})\\.",1);
    	System.out.println("--->"+a);
        Document doc = Jsoup.connect("http://www.baidu.com").get();
        String title = doc.title();
        System.out.println(title);
        
        Elements urls=doc.select("a");
        for(Element url:urls)
        {
            System.out.println(url.text().trim());
            System.out.println(url.attr("href"));
            System.out.println(url.html());
        }
    }

}

