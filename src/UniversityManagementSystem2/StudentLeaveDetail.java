package UniversityManagementSystem2;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetail extends JFrame implements ActionListener {

        Choice cRollNo;
        JButton search, print, cancel;

        JTable table;
        StudentLeaveDetail(){
            setLayout(null);
            getContentPane().setBackground(Color.white);

            JLabel label = new JLabel("Search Student leave");
            label.setBounds(30,10,180,30);
            label.setFont(new Font("ubuntu", Font.BOLD, 15));
            add(label);

            cRollNo= new Choice();
            cRollNo.setBounds(220,10,200,30);
            add(cRollNo);

            try{
                DBConnection connection= new DBConnection();
                ResultSet rs=connection.s.executeQuery("Select * from student");
                while(rs.next()){
                    cRollNo.add(rs.getString("rollNum"));
                }

            }catch(Exception e){
                e.printStackTrace();
            }


            table = new JTable();
            table.setBounds(10,100,880, 600);
            table.setBackground(Color.pink);


            JScrollPane scroll= new JScrollPane(table);
            scroll.setBounds(0,100,10,600);
            add(scroll);

            try{
                DBConnection connection= new DBConnection();
                ResultSet rs=connection.s.executeQuery("Select * from studentLeave");
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }
            add(table);

            search = new JButton("Search");
            search.setBounds(20,60,100, 30);
            search.setFont(new Font("ubuntu", Font.BOLD, 14));
            search.addActionListener(this);
            add(search);

            print = new JButton("Print");
            print.setBounds(140,60,100, 30);
            print.setFont(new Font("ubuntu", Font.BOLD, 14));
            print.addActionListener(this);
            add(print);


            cancel = new JButton("Cancel");
            cancel.setBounds(260,60,100, 30);
            cancel.setFont(new Font("ubuntu", Font.BOLD, 14));
            cancel.addActionListener(this);
            add(cancel);


            setLocation(300,100);
            setSize(900,700);
            setVisible(true);
        }


        public void actionPerformed(ActionEvent ae){

            if(ae.getSource()==search){

                try{
                    DBConnection connection= new DBConnection();
                    ResultSet rs= connection.s.executeQuery("Select * from studentleave where rollNum='"+cRollNo.getSelectedItem()+"'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                    e.printStackTrace();
                }

            } else if (ae.getSource()==print) {
                try{
                    table.print();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if (ae.getSource()==cancel) {
                setVisible(false);
            }

        }

        public static void main(String[] args) {
            new StudentLeaveDetail();
        }
}
