

package pos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author astha
 */
public class query {
    int weight[]=new int[100];// get the size of table
    String T_name;           // name of the table corrosponding to max_id.
    int ques_id;             // selected ques id
    
    int ques_selected(String[] noun_adv,int max_id,int index_adv) //words are the splitted input
                                     //max_id is the id of the selected table
                                                  
    {   try
       { 
          Statement stm=Conn.con.createStatement();
          String Tname="select table_name from chatterbot.main_table where id="+max_id;
          
          ResultSet rs1=stm.executeQuery(Tname);
          if(rs1.next())
          {  T_name=rs1.getString("table_name");
            // System.out.println(T_name);
          }
          String tquery="select *from chatterbot."+T_name;
          ResultSet rs=stm.executeQuery(tquery);
          
          int j=1;
          java.util.Arrays.fill(weight, 0);
         
          while(rs.next())
          {   //System.out.println("right");
              for(int i=0;i<index_adv;i++)
             {     
                 String matched=rs.getString("question");
                // System.out.println(matched);
                 //System.out.println(words[i]);
                 if(matched.indexOf(noun_adv[i])>=0)
                 {  
                     //System.out.println("**22**");
                     weight[j]=weight[j]+1;
                 }
                /* String squery="Select q_id from chatterbot."+T_name+" where question like '%"+words[i]+"%'";
                   PreparedStatement pstmt=Conn.con.prepareStatement(squery);
                   ResultSet rs2=pstmt.executeQuery();
                   if(rs2.next())
                   {  weight[j]=weight[j]+1;
                      
                
                    }*/
          }
              j++;
          }
          int max=weight[1];
           ques_id=1;
          for(int i=2;i<=j;i++)
          {   if(max<weight[i])
              { max=weight[i];
              //System.out.println(max);
              ques_id=i;
              }
          }
          if(max<2)
          {
              return 0;
          }
       // System.out.println(ques_id);
       }
    catch(Exception e)
    {System.out.println("query class error");
      e.printStackTrace();
     }
  // System.out.println(ques_id);
  /*  for(int q=0;q<index;q++)
    {
        System.out.println(noun[q]);
    }*/
    
    return ques_id;
    }
}