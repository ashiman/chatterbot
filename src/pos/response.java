
package pos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author astha
 */
public class response  {
    int weight[]=new int[20];// get the size of table
    String Tname;
    
    response(int max_id,int ques_id)//max_id is the id of selected table in main_table.
                                  //ques_id question id in particular ques table.
    {   try
       {  
          Statement stm=Conn.con.createStatement(); 
          String squery="select ans_table from chatterbot.main_table where id="+max_id;
          ResultSet rs1=stm.executeQuery(squery);
          if(rs1.next())
          {
              Tname=rs1.getString("ans_table");
             // System.out.println("in if"+Tname);
          }
          String tquery="select answer from chatterbot."+Tname+" where ref_id="+ques_id;
          
          ResultSet rs5=stm.executeQuery(tquery);
           
         
          if(rs5.next())
          {  //System.out.println("right "+ques_id);
             System.out.println(rs5.getString(1));
               
              
            }
          else
          {
              System.out.println("Sorry right now there is no answer for your ques");
          }
       }
    catch(Exception e)
    {System.out.println("response class error");
      e.printStackTrace();
     }
    }
}