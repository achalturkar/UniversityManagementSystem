package UniversityManagementSystem2;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeesStructure extends JFrame {


    FeesStructure(){
       getContentPane().setBackground(Color.white);
       setLayout(null);
       setTitle("Fees Detail");
       setLocation(200,100);
       setSize(800,600);

       JLabel head=new JLabel("Fees Structure");
       head.setBounds(50,20,220,30);
       head.setFont(new Font("ubuntu",Font.BOLD,25));
       add(head);

       JTable table = new JTable();
        table.setBounds(0,70,750, 500);
       try{
           DBConnection connection= new DBConnection();
           ResultSet rs= connection.s.executeQuery("Select * from fees");

           table.setModel(DbUtils.resultSetToTableModel(rs));

       }catch(Exception e){
           e.printStackTrace();
       }
       add(table);

       JScrollPane scroll= new JScrollPane();
       scroll.setBounds(775,60,25,540);
       add(scroll);

       setVisible(true);
    }

    public static void main(String[] args) {
        new FeesStructure();
    }
}
