package pos;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Potagger {
   String lower_s=new String();
   int i;
 MaxentTagger tagger = new MaxentTagger("C:\\Users\\user\\Documents\\NetBeansProjects\\pos\\taggers/english-left3words-distsim.tagger");
  public String noun[]=new String[10];
  public String adv_noun[]=new String[20];
  
   Potagger()
     { // lower_s=s.toLowerCase();
        //i=0;
     }
 int get_noun(String s)
   {  
      lower_s=s.toLowerCase();
        i=0;
       
      // MaxentTagger tagger = new MaxentTagger("C:\\Users\\astha\\Documents\\NetBeansProjects\\pos\\taggers/english-left3words-distsim.tagger");
         
  
  //  BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
  //  while ((s = inp.readLine()) != null) {
     //  s= inp.readLine();
   
     String[] words = lower_s.split(" ");  //string is tokenizedm
    for(int k=0;k<words.length;k++)
    {
      // System.out.println(words[k]);  //printing tokenized string array
    }
     for(int j=0;j<words.length;j++)
     {
          String tagged = tagger.tagString(words[j]);
         // System.out.println(tagged);
          int index=tagged.indexOf("_");
         // System.out.println(index);
         // System.out.println(tagged.substring(index+1));
          
         // if(tagged.substring(index+1).equalsIgnoreCase("NNS")||tagged.endsWith("NN")==true||tagged.substring(index+1).equalsIgnoreCase("NN"))
       /*  if(temp.compareTo("NN")==0)
         {
          
              noun[j]=words[j];
              System.out.println(noun[j]);
          }*/
          if(tagged.indexOf("_NN")>=0||tagged.indexOf("_NNS")>=0||tagged.indexOf("_NNP")>0)
          {
              noun[i]=words[j];
              i++;
             // System.out.println(noun[j]);
          }
     }
        
        for (int k=0;k<i;k++) {
           noun[k]= noun[k].toUpperCase();
           // System.out.println(noun[k]);
        }
      //  SelectTable st=new SelectTable();
      //  st.selectt(noun, i);
      return i;
   }
 String[] get_array()
 { 
     return noun;
     
 }
 
 
 int get_noun_adverb(String s)
 {    
      lower_s=s.toLowerCase();
        i=0;
         String[] words = lower_s.split(" ");  //string is tokenizedm
    for(int k=0;k<words.length;k++)
    {
      // System.out.println(words[k]);  //printing tokenized string array
    }
     for(int j=0;j<words.length;j++)
     {
          String tagged = tagger.tagString(words[j]);
        // System.out.println(tagged);
          int index=tagged.indexOf("_");
             if(tagged.indexOf("_RB")>=0||tagged.indexOf("_RBR")>=0||tagged.indexOf("_RBS")>0||tagged.indexOf("_NN")>=0||tagged.indexOf("_NNS")>=0||tagged.indexOf("_NNP")>0||tagged.indexOf("_JJ")>0)
          {
              adv_noun[i]=words[j];
              i++;
             // System.out.println(noun[j]);
          }
     }
        
        for (int k=0;k<i;k++) {
           adv_noun[k]= adv_noun[k].toUpperCase();
           // System.out.println(noun[k]);
        }
      //  SelectTable st=new SelectTable();
      //  st.selectt(noun, i);
      /*  for(int q=0;q<i;q++)
        {
            System.out.println(adv_noun[q]);
        }*/
      return i;
     
 }
 String[] get_adv_noun_array()
 {
     return adv_noun;
 }

} 
   

  /*  public static void main(String[] args) throws java.lang.Exception,IOException,ClassNotFoundException {
         
    String s=new String(" ");
    
    String noun[]=new String[10];
    MaxentTagger tagger = new MaxentTagger("C:\\Users\\astha\\Documents\\NetBeansProjects\\pos\\taggers/english-left3words-distsim.tagger");
         
  
    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
  //  while ((s = inp.readLine()) != null) {
       s= inp.readLine();
   
      String[] words = s.split(" ");  //string is tokenizedm
    for(int i=0;i<words.length;i++)
    {
       System.out.println(words[i]);  //printing tokenized string array
    }
     for(int j=0,i=0;j<words.length;j++)
     {
          String tagged = tagger.tagString(words[j]);
         // System.out.println(tagged);
          int index=tagged.indexOf("_");
         // System.out.println(index);
         // System.out.println(tagged.substring(index+1));
          
         // if(tagged.substring(index+1).equalsIgnoreCase("NNS")||tagged.endsWith("NN")==true||tagged.substring(index+1).equalsIgnoreCase("NN"))
       /*  if(temp.compareTo("NN")==0)
         {
          
              noun[j]=words[j];
              System.out.println(noun[j]);
          }
          if(tagged.indexOf("_NN")>=0||tagged.indexOf("_NNS")>=0||tagged.indexOf("_NNP")>0)
          {
              noun[i]=words[j];
              i++;
             // System.out.println(noun[j]);
          }
     }
        
        for (String noun1 : noun) {
            System.out.println(noun1);
        } */


     
    





  