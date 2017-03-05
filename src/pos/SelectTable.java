
package pos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author astha
 */
public class SelectTable  {
    int weight[]=new int[20];// get the size of table
   public  int max_id;
    
    
   int select_t(String[] noun,int index)
    {   try
       {  Statement stm=Conn.con.createStatement();
          ResultSet rs=stm.executeQuery("Select * from chatterbot.main_table");
          int j=1;
          java.util.Arrays.fill(weight, 0);
         
          while(rs.next())
          {   
              for(int i=0;i<index;i++)
             {   String matched=rs.getString("keywords");
                // System.out.println(matched);
                 //System.out.println(noun[i]);
                 if(matched.indexOf(noun[i])>=0)
                 {  //System.out.println("in if");
                     weight[j]=weight[j]+1;
                    
                 }
             }
              j++;
                 
          }    
                 
               /*  String squery="Select id from chatterbot.main_table where keywords like '%"+noun[i]+"%'";
                   PreparedStatement pstmt=Conn.con.prepareStatement(squery);
                   ResultSet rs2=pstmt.executeQuery();
                   if(rs2.next()==true)
                   {  weight[j]=weight[j]+1;
                      
                
                    }
          }
              j++;
          }*/
          int max=weight[1];
          max_id=1;
          for(int i=2;i<=j;i++)
          {   if(max<weight[i])
              { max=weight[i];
               max_id=i;
              }
          }
          //System.out.println(max_id);
       }
    catch(Exception e)
    {      System.out.println("Select table exception");
            e.printStackTrace();
     }
    return max_id;
    }
}