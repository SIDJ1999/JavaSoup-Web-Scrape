/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import opennlp.tools.tokenize.SimpleTokenizer;

/**
 *
 * @author Student
 */
public class similarityCheck2Doc {
    public static void main(String args[]) throws IOException{
    Document document,document1;
        Stack<String> stack=new Stack<>();
        List<String> visited= new ArrayList<>();
    	//Get Document object after parsing the html from given url.
	document = Jsoup.connect("https://www.google.com/").get();
        document1 = Jsoup.connect("https://www.youtube.com").get();
        String txt= document.text();	
        String txt1= document1.text();

        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        
        String tokens[] = simpleTokenizer.tokenize(txt);
        String tokens1[] = simpleTokenizer.tokenize(txt1);
       //Hashing Document  
        HashMap < String, Integer > hmap = new HashMap < String, Integer > ();
          for (String str: tokens) {
              if (hmap.get(str) == null) 
              {
                hmap.put(str, 1);
              }
              else {
              hmap.put(str, hmap.get(str) + 1);
                 }
              }
          //Hashing Document 1
          HashMap < String, Integer > hmap1 = new HashMap < String, Integer > ();
          for (String str: tokens1) {
              if (hmap1.get(str) == null) 
              {
                hmap1.put(str, 1);
              }
              else {
              hmap1.put(str, hmap1.get(str) + 1);
                 }
              }
          System.out.println(hmap);
          System.out.println(hmap1);
    }
}