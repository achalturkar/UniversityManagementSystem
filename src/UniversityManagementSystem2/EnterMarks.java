package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class EnterMarks extends JFrame implements ActionListener {

    Choice cRollNo;

    JTextField mark1, mark2, mark3, mark4, mark5, sub1, sub2, sub3, sub4, sub5;

    JComboBox sem;

    JButton submit, cancel;

    EnterMarks(){
        setTitle("Student Marks");
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,80,350,250);
        add(image);

        JLabel head = new JLabel("Enter Student Marks");
        head.setBounds(150,10,400,40);
        head.setFont(new Font("serif",Font.BOLD, 30));
        add(head);

        JLabel label = new JLabel("Search RollNo.");
        label.setBounds(20,60,150,30);
        label.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(label);

        cRollNo= new Choice();
        cRollNo.setBounds(170,60,200,30);
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

        JLabel labelSem = new JLabel("Enter Semester");
        labelSem.setBounds(20,100,150,30);
        labelSem.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(labelSem);

        String semester[]= {"semester1", "semester2","semester3", "semester4","semester5","semester6","semester7","semester8"};
        sem= new JComboBox(semester);
        sem.setBounds(170,100,200,30);
        add(sem);

        JLabel labelSubject = new JLabel("Subject");
        labelSubject.setBounds(50,150,150,30);
        labelSubject.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(labelSubject);

        JLabel labelmark = new JLabel("Marks");
        labelmark.setBounds(280,150,150,30);
        labelmark.setFont(new Font("ubuntu", Font.BOLD, 15));
        add(labelmark);


        sub1 = new JTextField();
        sub1.setBounds(30,180,150,30);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(30,220,150,30);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(30,260,150,30);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(30,300,150,30);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(30,340,150,30);
        add(sub5);

        mark1 = new JTextField();
        mark1.setBounds(230,180,150,30);
        add(mark1);

        mark2 = new JTextField();
        mark2.setBounds(230,220,150,30);
        add(mark2);

        mark3 = new JTextField();
        mark3.setBounds(230,260,150,30);
        add(mark3);

        mark4 = new JTextField();
        mark4.setBounds(230,300,150,30);
        add(mark4);

        mark5 = new JTextField();
        mark5.setBounds(230,340,150,30);
        add(mark5);


        submit= new JButton("Submit");
        submit.setBounds(60,380,100,30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBounds(240,380,100,30);
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setLocation(300,200);
        setSize(900,500);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==submit){

            try{
                DBConnection connection = new DBConnection();

                String query1= "insert into subject values('"+cRollNo.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String query2= "insert into marks values('"+cRollNo.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+mark1.getText()+"','"+mark2.getText()+"','"+mark3.getText()+"','"+mark4.getText()+"','"+mark5.getText()+"')";

                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Entered Successfully");

            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
            new EnterMarks();
    }
}
