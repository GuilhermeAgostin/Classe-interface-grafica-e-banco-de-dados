package Conexao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionClass 

{

    public static java.sql.Connection con;
	
    public static ResultSet rs;
    public static PreparedStatement ps;
	 //bd db4free.net
     public static String url = "jdbc:mysql://a2nlmysql7plsk.secureserver.net:3306/BANCOJAVA";
     public static String user = "GUILHERME";
	 public  static     String password = "@_agostin";


}
