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
import java.util.HashMap;
import opennlp.tools.tokenize.SimpleTokenizer;

public class NLP { 
   public static void main(String args[]) throws IOException{ 
     
      Document document = Jsoup.connect("https://www.google.com/").get();
      String txt= document.text();
     // String sentence = "so so so so" + " We provide free tutorials on various technologies"; 
    
      //Instantiating SimpleTokenizer class 
      SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;  
       
      //Tokenizing the given sentence 
      String tokens[] = simpleTokenizer.tokenize(txt);  
       
      //Printing the tokens 
  //    for(String token : tokens) {         
 //        System.out.println(token);  
  //    }       
      
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
         // System.out.println(hmap.getKey());
         // System.out.println(hmap.getValue());
         System.out.println(hmap);
   }  
}
