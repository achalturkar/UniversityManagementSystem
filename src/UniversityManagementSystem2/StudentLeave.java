package UniversityManagementSystem2;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener{

     JButton submit, cancel;
    Choice cRollNo, cDuration;
    JDateChooser leaveDate;

    JTextArea cmt;
    StudentLeave(){

        setLayout(null);
        setTitle("Student Leave");

        JLabel labelLeave= new JLabel("Application Leave For Student");
        labelLeave.setBounds(120,10,300,40);
        labelLeave.setFont(new Font("ubuntu", Font.BOLD, 20));
        add(labelLeave);

        JLabel labelSt= new JLabel("Search Student for Leave");
        labelSt.setBounds(40,60,200,30);
        labelSt.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(labelSt);

        cRollNo= new Choice();
        cRollNo.setBounds(40,100,200,30);
        add(cRollNo);

        try{
            DBConnection connection=new DBConnection();
            ResultSet rs= connection.s.executeQuery("Select * from student ");
            while(rs.next()){
                cRollNo.add(rs.getString("rollNum"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel labelDate= new JLabel("Leave Date");
        labelDate.setBounds(40,140,100,30);
        labelDate.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(labelDate);

        leaveDate = new JDateChooser();
        leaveDate.setBounds(40,170,200,30);
        add(leaveDate);


        JLabel durationLabel= new JLabel("Time Duration");
        durationLabel.setBounds(40,210,150,30);
        durationLabel.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(durationLabel);

        cDuration = new Choice();
        cDuration.setBounds(40,250,200,30);
        cDuration.add("Full Day");
        cDuration.add("Half Day");
        add(cDuration);

        JLabel cmtLabel= new JLabel("Add Comment");
        cmtLabel.setBounds(40,290,150,30);
        cmtLabel.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(cmtLabel);

        cmt= new JTextArea();
        cmt.setBounds(40,330, 450, 70);
        add(cmt);



         submit= new JButton("Confirm");
        submit.setBounds(100,410,100,30);
        submit.setFont(new Font("ubuntu",Font.BOLD, 15));
        submit.setBackground(Color.blue);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
         add(submit);

         cancel= new JButton("Cancel");
        cancel.setBounds(300,410,100,30);
        cancel.setFont(new Font("ubuntu",Font.BOLD, 15));
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
         add(cancel);



        setSize(600,500);
        setLocation(400,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){

            String rollNum= cRollNo.getSelectedItem();
            String date=((JTextField) leaveDate.getDateEditor().getUiComponent()).getText();
            String duration=cDuration.getSelectedItem();
            String comment= cmt.getText();

            String query= "insert into studentLeave values('"+rollNum+"','"+date+"','"+duration+"','"+comment+"')"+"";


            try{
                DBConnection connection = new DBConnection();
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");

            }catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }


    public static void main(String[] args) {

        new StudentLeave();
    }
}
