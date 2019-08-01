/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import opennlp.tools.tokenize.SimpleTokenizer;  
public class NLP { 
   public static void main(String args[]){ 
     
      String sentence = "so so so so" 
         + "We provide free tutorials on various technologies"; 
    
      //Instantiating SimpleTokenizer class 
      SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;  
       
      //Tokenizing the given sentence 
      String tokens[] = simpleTokenizer.tokenize(sentence);  
       
      //Printing the tokens 
      for(String token : tokens) {         
         System.out.println(token);  
      }       
   }  
}
