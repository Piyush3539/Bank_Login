
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Sqlconnection
 {       
    
    public static Connection sqlGetConnection(){
       Connection con=null;
       try{
       FileInputStream fis=new FileInputStream("C:\\Users\\P_Verma\\Documents\\NetBeansProjects\\Piyush projects\\BankSwing\\src\\newproperties.properties");
       Properties prop=new Properties();
       prop.load(fis);
       String drivers=prop.getProperty("Mysql_Drivers");
       String url=prop.getProperty("Mysql_URl");
       String user_name=prop.getProperty("Mysql_Username");
       String pass_word=prop.getProperty("Mysql_Password");
       Class.forName(drivers);
       con =DriverManager.getConnection(url,user_name, pass_word);
      
      
    } 
    
    catch(IOException | ClassNotFoundException | SQLException e){
            System.out.println(e);
    }
 return con;
    }
}
