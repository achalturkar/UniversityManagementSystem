package UniversityManagementSystem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
        Connection conn= null;
        Statement s;
    DBConnection(){
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/UniversityManagementSystem","postgres","Achal@85");

            if(conn!= null){
                System.out.println("Connection to Database Established");
                s=conn.createStatement();
            }
            else{
                System.out.println("Connection to Database is Failed");
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}
