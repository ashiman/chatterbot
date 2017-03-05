package pos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Random;


public class Botify {
    
public static void main(String args[])
{  chatbot c=new chatbot();
   
   String sResponse = "";
   String sInput = "";
  
    int id = 0;
   int count=0;
   int cnt=0;
   int nSelection=0;
   Potagger p=new Potagger();
    try
    {    
       while(true)
       {
       System.out.print(">");
			String sPrevInput = sInput;
			String sPrevResponse = sResponse;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			sInput = in.readLine();
                       // System.out.println(sInput);
                        sInput = c.preProcessInput(sInput);
                        if(sInput.equalsIgnoreCase("BYE")||sInput.equalsIgnoreCase("BYEE"))
                        {
                            System.out.println("Nice Talking to you , Bye");
                            break;
                        }
                        if(sInput.equalsIgnoreCase("hi")||sInput.equalsIgnoreCase("hey")||sInput.equalsIgnoreCase("hello"))
                        {
                            System.out.println("Hello");
                            continue;
                        }
                        
                        int index=p.get_noun(sInput);
                        int index_adv=p.get_noun_adverb(sInput);
                        String[] noun_adv=p.get_adv_noun_array();
                        String[] noun=p.get_array();
                        SelectTable st=new SelectTable();
                        int max_id=   st.select_t(noun, index);
                        String[]words=sInput.split(" "); 
                        
                        query qu=new query();
                        int ques_id=qu.ques_selected(noun_adv, max_id,index_adv);// changed from word to noun
                       // System.out.println("ques_id"+ques_id);
                        if(ques_id==0)
                        {  
                            System.out.println("Sorry I did not get you ,please elaborate");
                            continue;
                        }
                        response re=new response(max_id,ques_id);
                        
                      
                        
                        
               }
                         
        }     
                   
     catch(Exception e)
   {  System.out.println("botify exception");
       System.out.println(e);
   }
//  System.out.println(count);

    

}

   
}

