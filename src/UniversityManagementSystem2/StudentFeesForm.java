package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentFeesForm extends JFrame implements ActionListener {

    Choice cRoll;
    JComboBox cbsemester;

    JButton update, pay, back, search;

    JLabel feeL, coLab, branchL, nLabel, lLabel;

    StudentFeesForm(){

        setTitle("Student Fees Form");
        setLayout(null);
        setLocation(200,100);
        setSize(800,450);
        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,400,300);
        add(image);

        JLabel roll = new JLabel("Roll Number :");
        roll.setBounds(20,30,150,30);
        roll.setFont(new Font("ubuntu",Font.BOLD,18));
        roll.setForeground(Color.black);
        add(roll);

        cRoll= new Choice();
        cRoll.setBounds(170,30,150,30);
        cRoll.setFont(new Font("ubuntu",Font.BOLD,15));
        add(cRoll);

        try{
            DBConnection connection= new DBConnection();
            ResultSet rs= connection.s.executeQuery("select * from student");
            while(rs.next()){
                cRoll.add(rs.getString("rollNum"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(320, 30, 100, 25);
        search.setBackground(Color.blue);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        search.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(search);

        JLabel name = new JLabel("First Name :");
        name.setBounds(20,70,150,30);
        name.setFont(new Font("ubuntu",Font.BOLD,18));
        name.setForeground(Color.black);
        add(name);

         nLabel= new JLabel();
        nLabel.setForeground(Color.BLACK);
        nLabel.setBounds(170,70,150,30);
        nLabel.setFont(new Font("ubuntu",Font.BOLD,18));
        add(nLabel);

        JLabel Lname = new JLabel("Last Name :");
        Lname.setBounds(20,110,150,30);
        Lname.setFont(new Font("ubuntu",Font.BOLD,18));
        Lname.setForeground(Color.black);
        add(Lname);

         lLabel= new JLabel();
        lLabel.setForeground(Color.BLACK);
        lLabel.setBounds(170,110,150,30);
        lLabel.setFont(new Font("ubuntu",Font.BOLD,18));
        add(lLabel);


        try{
            DBConnection connection=new DBConnection();
            ResultSet rs= connection.s.executeQuery("select * from student where rollNum='"+cRoll.getSelectedItem()+"'");
            while(rs.next()){
                nLabel.setText(rs.getString("fname"));
                lLabel.setText(rs.getString("lastname"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel courseLable = new JLabel("Course :");
        courseLable.setBounds(20,150,150,30);
        courseLable.setFont(new Font("ubuntu",Font.BOLD,18));
        courseLable.setForeground(Color.black);
        add(courseLable);

         coLab= new JLabel();
        coLab.setBounds(170,150,150,30);
        coLab.setFont(new Font("ubuntu",Font.BOLD,18));
        add(coLab);




        JLabel branLable = new JLabel("Branch :");
        branLable.setBounds(20,190,100,30);
        branLable.setFont(new Font("ubuntu",Font.BOLD,18));
        branLable.setForeground(Color.black);
        add(branLable);

         branchL= new JLabel();
        branchL.setForeground(Color.BLACK);
        branchL.setBounds(170,190,220,30);
        branchL.setFont(new Font("ubuntu",Font.BOLD,18));
        add(branchL);


        try{
            DBConnection connection=new DBConnection();
            ResultSet rs= connection.s.executeQuery("select * from student where rollNum='"+cRoll.getSelectedItem()+"'");
            while(rs.next()){
                coLab.setText(rs.getString("course"));
                branchL.setText(rs.getString("branch"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }



        JLabel sem = new JLabel("Semester :");
        sem.setBounds(20,230,150,30);
        sem.setFont(new Font("ubuntu",Font.BOLD,18));
        sem.setForeground(Color.black);
        add(sem);

        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(170, 230, 150, 30);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);


        JLabel payLable = new JLabel("Fees Payable :");
        payLable.setBounds(20,270,150,30);
        payLable.setFont(new Font("ubuntu",Font.BOLD,18));
        payLable.setForeground(Color.black);
        add(payLable);

         feeL= new JLabel();
         feeL.setBounds(170,270,150,30);
        feeL.setFont(new Font("ubuntu",Font.BOLD,18));
         add(feeL);





        update = new JButton("Update");
        update.setBounds(30, 350, 100, 25);
        update.setBackground(Color.blue);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 350, 100, 25);
        pay.setBackground(Color.blue);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 350, 100, 25);
        back.setBackground(Color.blue);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);






        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==update){
            String course=  coLab.getText();
            String semester=(String) cbsemester.getSelectedItem();

            try {
                DBConnection connection= new DBConnection();
                ResultSet rs= connection.s.executeQuery("select * from fees where course='"+course+"'");
                while(rs.next()){
                    feeL.setText(rs.getString(semester));
                }

            }catch (Exception e){
                e.printStackTrace();
            }



        } else if (ae.getSource()==search) {

            try{
                DBConnection connection= new DBConnection();
                ResultSet rs= connection.s.executeQuery("Select * from student where rollNum='"+cRoll.getSelectedItem()+"'");
                while(rs.next()){
                    nLabel.setText(rs.getString("fname"));
                    lLabel.setText(rs.getString("lastName"));
                    coLab.setText(rs.getString("course"));
                    branchL.setText(rs.getString("branch"));

                }

            }catch (Exception e){
                e.getMessage();
            }


        } else if (ae.getSource()==pay) {
            String rollNum=cRoll.getSelectedItem();
            String branch= branchL.getText();
            String course= coLab.getText();
            String semester= (String)cbsemester.getSelectedItem();
            String fees=feeL.getText();

            try {
                DBConnection connection=new DBConnection();
                String query= "insert into feesSubmit values('"+rollNum+"','"+course+"','"+branch+"','"+semester+"','"+fees+"')";

                connection.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "fees is submitted");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentFeesForm();
    }
}
