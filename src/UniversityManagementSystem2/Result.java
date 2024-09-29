package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Result extends JFrame implements ActionListener {

    String rollNum;
    JButton cancel, print;
    Result(String rollNum){
         this.rollNum=rollNum;

         setTitle("Result");
         setLayout(null);
         getContentPane().setBackground(Color.white);

         JLabel head = new JLabel("Ramdeobaba University Nagpur");
         head.setFont(new Font("ubuntu",Font.BOLD,20));
         head.setBounds(80,10,400,30);
         add(head);

         JLabel subHead = new JLabel("Examination Result 2024");
         subHead.setFont(new Font("ubuntu",Font.BOLD,17));
         subHead.setBounds(130,40,400,30);
         add(subHead);

         JLabel rollLabel = new JLabel("Student Roll Number  "+ rollNum);
         rollLabel.setFont(new Font("ubuntu",Font.PLAIN,17));
         rollLabel.setBounds(80,80,300,30);
         add(rollLabel);

         JLabel semLabel = new JLabel();
         semLabel.setFont(new Font("ubuntu",Font.PLAIN,17));
         semLabel.setBounds(80,110,300,30);
         add(semLabel);

         JLabel sub1Label = new JLabel();
         sub1Label.setFont(new Font("ubuntu",Font.BOLD,17));
         sub1Label.setBounds(50,150,300,30);
         add(sub1Label);

         JLabel sub2Label = new JLabel();
         sub2Label.setFont(new Font("ubuntu",Font.BOLD,17));
         sub2Label.setBounds(50,180,300,30);
         add(sub2Label);

         JLabel sub3Label = new JLabel();
         sub3Label.setFont(new Font("ubuntu",Font.BOLD,17));
         sub3Label.setBounds(50,210,300,30);
         add(sub3Label);

         JLabel sub4Label = new JLabel();
         sub4Label.setFont(new Font("ubuntu",Font.BOLD,17));
         sub4Label.setBounds(50,240,300,30);
         add(sub4Label);

         JLabel sub5Label = new JLabel();
         sub5Label.setFont(new Font("ubuntu",Font.BOLD,17));
         sub5Label.setBounds(50,270,300,30);
         add(sub5Label);

         try{
             DBConnection connection = new DBConnection();
             ResultSet rs1= connection.s.executeQuery("select * from subject where rollNum='"+rollNum+"'");
             while(rs1.next()){
                 sub1Label.setText(rs1.getString("subject1"));
                 sub2Label.setText(rs1.getString("subject2"));
                 sub3Label.setText(rs1.getString("subject3"));
                 sub4Label.setText(rs1.getString("subject4"));
                 sub5Label.setText(rs1.getString("subject5"));
             }

             ResultSet rs2 = connection.s.executeQuery("select * from marks where rollNum = '"+rollNum+"'");
             while(rs2.next()) {
                 sub1Label.setText(sub1Label.getText() + "------------" + rs2.getString("mark1"));
                 sub2Label.setText(sub2Label.getText() + "------------" + rs2.getString("mark2"));
                 sub3Label.setText(sub3Label.getText() + "------------" + rs2.getString("mark3"));
                 sub4Label.setText(sub4Label.getText() + "------------" + rs2.getString("mark4"));
                 sub5Label.setText(sub5Label.getText() + "------------" + rs2.getString("mark5"));
                 semLabel.setText("Semester " + rs2.getString("semester"));
             }

         }catch(Exception e){
             e.printStackTrace();
         }


         cancel = new JButton("Cancel");
         cancel.setBounds(120,320,100,30);
         cancel.setFont(new Font("Tohoma",Font.BOLD,15));
         cancel.setBackground(Color.blue);
         cancel.setForeground(Color.white);
         cancel.addActionListener(this);
         add(cancel);
         setSize(500,500);
         setLocation(400,100);
         setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Result("");
    }
}
