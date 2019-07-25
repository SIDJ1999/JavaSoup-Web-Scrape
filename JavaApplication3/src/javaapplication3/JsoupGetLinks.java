/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.util.Stack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
/**
 * This class is used get links from HTML using Jsoup.
 * @author codesjava
 */
public class JsoupGetLinks {
  public static void main(String args[]){
    Document document,document1;
    try {
        Stack<String> stack=new Stack<>();
        List<String> visited= new ArrayList<>();
    	//Get Document object after parsing the html from given url.
	document = Jsoup.connect("https://www.youtube.com/").get();
        stack.push("https://www.youtube.com/");
 
	//Get links from document object. 
	Elements links = document.select("a[href]");
        
	//Iterate links and print link attributes.
	for (Element link : links) {
                stack.push(link.attr("href"));
		System.out.println("Link: " + link.attr("href"));
		System.out.println("Text: " + link.text());
		System.out.println("");
	}
        for(int i=0;i<10;i++)
        {
          String url=stack.pop();
          visited.add(url);
          document1 = Jsoup.connect("url").get();
          Elements links1 = document1.select("a[href]");
          for (Element link1 : links) {
                if((!(visited.contains(link1.attr("href")))) && (!(stack.contains(link1.attr("href")))))
                {
                     stack.push(link1.attr("href"));
                     System.out.println("Link: " + link1.attr("href"));
                    System.out.println("Text: " + link1.text());
                    System.out.println("");
                }
	}
        }
 
    } catch (IOException e) {
    }		
  }
}