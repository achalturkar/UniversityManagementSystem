package UniversityManagementSystem2;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FacultyDetail extends JFrame implements ActionListener {

        Choice cEmpId;
        JButton search, print, add, update, cancel;

        JTable table;
        FacultyDetail(){
            setLayout(null);
            getContentPane().setBackground(Color.white);

            JLabel label = new JLabel("Search Faculty");
            label.setBounds(30,10,180,30);
            label.setFont(new Font("ubuntu", Font.BOLD, 15));
            add(label);

            cEmpId= new Choice();
            cEmpId.setBounds(220,10,200,30);
            add(cEmpId);

            try{
                DBConnection connection= new DBConnection();
                ResultSet rs=connection.s.executeQuery("Select * from teacher");
                while(rs.next()){
                    cEmpId.add(rs.getString("employeeID"));
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
                ResultSet rs=connection.s.executeQuery("Select * from teacher");
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

            add = new JButton("Add");
            add.setBounds(260,60,100, 30);
            add.setFont(new Font("ubuntu", Font.BOLD, 14));
            add.addActionListener(this);
            add(add);

            update = new JButton("Update");
            update.setBounds(380,60,100, 30);
            update.setFont(new Font("ubuntu", Font.BOLD, 14));
            update.addActionListener(this);
            add(update);

            cancel = new JButton("Cancel");
            cancel.setBounds(500,60,100, 30);
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
                    ResultSet rs= connection.s.executeQuery("Select * from teacher where employeeID='"+cEmpId.getSelectedItem()+"'");
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
            }else if (ae.getSource()==add) {
                new AddTeacher();

            }else if (ae.getSource()==update) {

            }else if (ae.getSource()==cancel) {
                setVisible(false);
            }

        }

        public static void main(String[] args) {
                 new FacultyDetail();
        }

}
