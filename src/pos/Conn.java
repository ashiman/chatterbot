
package pos;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author astha
 */
public class Conn {
    static Connection con;
    static 
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chatterbot","root","anu30@radha");
           // System.out.println("Connected");
        } catch (Exception ex) {
             System.out.println("not connected");
             ex.printStackTrace();
        }
    }
}
