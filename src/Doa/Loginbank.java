package Doa;
import java.sql.*;
import util.Sqlconnection;
import javax.swing.JOptionPane;
public class Loginbank 
{
   String username;
   String password;

    public Loginbank(String username, String password) 
    {
        this.username=username;
        this.password=password;
        check();
    }
   void check()
   {
       String username=null;
       String password=null;
       
      try{ 
       Connection con= Sqlconnection.sqlGetConnection();
       PreparedStatement ps=con.prepareStatement("select * from bank where username= ? ");
       ps.setString(1,this.username);
       ResultSet rs=ps.executeQuery();
       for(;rs.next();)// while loop for tables -----while(rs.next())--
       {
           username=rs.getString("username");
           password=rs.getString("password");    
       }
          
       if(this.username.equals(username)&& this.password.equals(password))
       {
          
           JOptionPane.showMessageDialog(null,"Welcome");
          
       }
       else
       {    
           
          JOptionPane.showMessageDialog(null, "Enter correct details");
       }
      }
      catch(SQLException e){
          System.out.println(e);
      }    
   }
}