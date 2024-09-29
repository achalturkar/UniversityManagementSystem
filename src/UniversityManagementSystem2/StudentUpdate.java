package UniversityManagementSystem2;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentUpdate extends JFrame implements ActionListener {

        JTextField tfBranch, tfCourse, add, ph, email ;
        JLabel rollNo;

        JButton update, cancel;
        Choice cRollNo;

        StudentUpdate(){
            setTitle("Update Student");
            setLayout(null);
            setLocation(400,100);
            setSize(800,600);

            JLabel head = new JLabel("Update Student Detail");
            head.setBounds(40,10,400,40);
            head.setFont(new Font("serif",Font.BOLD, 30));
            add(head);

            JLabel label = new JLabel("Search Student For Update");
            label.setBounds(20,60,230,30);
            label.setFont(new Font("ubuntu", Font.BOLD, 15));
            add(label);

            cRollNo= new Choice();
            cRollNo.setBounds(260,60,280,30);
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

            JLabel nameLabel = new JLabel("Name");
            nameLabel.setBounds(30,100,80,30);
            nameLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(nameLabel);


            JLabel nLabel = new JLabel();
            nLabel.setBounds(120,100,200,30);
            nLabel.setFont(new Font("serif",Font.PLAIN, 15));
            add(nLabel);

            JLabel nameFLabel = new JLabel("Father Name");
            nameFLabel.setBounds(350,100,150,30);
            nameFLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(nameFLabel);

            JLabel fLabel = new JLabel();
            fLabel.setBounds(500,100,200,30);
            fLabel.setFont(new Font("serif",Font.PLAIN, 15));
            add(fLabel);

            JLabel surnameLabel = new JLabel("surname");
            surnameLabel.setBounds(30,150,80,30);
            surnameLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(surnameLabel);

            JLabel sLabel = new JLabel();
            sLabel.setBounds(120,150,200,30);
            sLabel.setFont(new Font("serif",Font.PLAIN, 15));
            add(sLabel);

            JLabel rollNoLabel = new JLabel("Roll Number");
            rollNoLabel.setBounds(30,200,120,30);
            rollNoLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(rollNoLabel);

            rollNo = new JLabel();
            rollNo.setBounds(160,200,150,30);
            rollNo.setFont(new Font("serif",Font.BOLD, 18));
            add(rollNo);

            JLabel dobLabel = new JLabel("Date Of Birth");
            dobLabel.setBounds(350,200,120,30);
            dobLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(dobLabel);

            JLabel date = new JLabel();
            date.setBounds(500,200,120,30);
            date.setFont(new Font("serif",Font.BOLD, 15));
            add(date);

            JLabel addressLabel = new JLabel("Address");
            addressLabel.setBounds(30,250,150,30);
            addressLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(addressLabel);

            add = new JTextField();
            add.setBounds(120,250,200,30);
            add(add);

            JLabel phoneLabel = new JLabel("Phone No.");
            phoneLabel.setBounds(350,250,150,30);
            phoneLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(phoneLabel);

            ph = new JTextField();
            ph.setBounds(500,250,200,30);
            add(ph);

            JLabel emailLabel = new JLabel("Email");
            emailLabel.setBounds(30,300,150,30);
            emailLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(emailLabel);

            email = new JTextField();
            email.setBounds(120,300,200,30);
            add(email);

            JLabel perXLabel = new JLabel("10th%");
            perXLabel.setBounds(350,300,150,30);
            perXLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(perXLabel);

            JLabel labelX = new JLabel();
            labelX.setBounds(500,300,200,30);
            add(labelX);

            JLabel perXIILabel = new JLabel("12th%");
            perXIILabel.setBounds(30,350,150,30);
            perXIILabel.setFont(new Font("serif",Font.BOLD, 18));
            add(perXIILabel);

            JLabel labelXII = new JLabel();
            labelXII.setBounds(120,350,200,30);
            add(labelXII);

            JLabel aadharLabel = new JLabel("Aadhar No.");
            aadharLabel.setBounds(350,350,150,30);
            aadharLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(aadharLabel);

            JLabel labelAa= new JLabel();
            labelAa.setBounds(500,350,200,30);
            labelAa.setFont(new Font("serif",Font.BOLD, 15));
            add(labelAa);

            JLabel courseLabel = new JLabel("Course");
            courseLabel.setBounds(30,400,150,30);
            courseLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(courseLabel);

             tfCourse = new JTextField();
            tfCourse.setBounds(120, 400,200,30);
            add(tfCourse);

            JLabel branchLabel = new JLabel("Branch");
            branchLabel.setBounds(350,400,150,30);
            branchLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(branchLabel);

             tfBranch = new JTextField();
            tfBranch.setBounds(500, 400,200,30);
            add(tfBranch);

            try {
                 DBConnection connection= new DBConnection();
                 String query= "select * from student where rollNum='"+cRollNo.getSelectedItem()+"'";
                 ResultSet rs= connection.s.executeQuery(query);
                 while(rs.next()){
                     nLabel.setText(rs.getString("fName"));
                     fLabel.setText(rs.getString("midName"));
                     sLabel.setText(rs.getString("lastName"));
                     labelAa.setText(rs.getString("aadharNum"));
                     labelX.setText(rs.getString("tenPer"));
                     labelXII.setText(rs.getString("twelvePer"));
                     date.setText(rs.getString("dob"));
                     ph.setText(rs.getString("phone"));
                     add.setText(rs.getString("address"));
                     email.setText(rs.getString("mail"));
                     rollNo.setText(rs.getString("rollNum"));
                     tfBranch.setText(rs.getString("branch"));
                     tfCourse.setText(rs.getString("Course"));
                 }


            }catch (Exception e){
                e.printStackTrace();
            }

            cRollNo.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {
                        DBConnection connection= new DBConnection();
                        String query= "select * from student where rollNum='"+cRollNo.getSelectedItem()+"'";
                        ResultSet rs= connection.s.executeQuery(query);
                        while(rs.next()){
                            nLabel.setText(rs.getString("fName"));
                            fLabel.setText(rs.getString("midName"));
                            sLabel.setText(rs.getString("lastName"));
                            labelAa.setText(rs.getString("aadharNum"));
                            labelX.setText(rs.getString("tenPer"));
                            labelXII.setText(rs.getString("twelvePer"));
                            date.setText(rs.getString("dob"));
                            ph.setText(rs.getString("phone"));
                            add.setText(rs.getString("address"));
                            email.setText(rs.getString("mail"));
                            rollNo.setText(rs.getString("rollNum"));
                            tfBranch.setText(rs.getString("branch"));
                            tfCourse.setText(rs.getString("Course"));
                        }


                    }catch (Exception a){
                        a.printStackTrace();
                    }
                }
            });

            update = new JButton("Update");
            update.setBounds(200,480, 100, 40);
            update.setBackground(Color.blue);
            update.setForeground(Color.WHITE);
            update.setFont(new Font("ubuntu",Font.BOLD, 15));
            update.addActionListener(this);
            add(update);

            cancel = new JButton("Cancel");
            cancel.setBounds(400,480, 100, 40);
            cancel.setBackground(Color.blue);
            cancel.setForeground(Color.WHITE);
            cancel.setFont(new Font("ubuntu",Font.BOLD, 15));
            cancel.addActionListener(this);
            add(cancel);





            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){

            if(ae.getSource()==update){


                String rollNum = rollNo.getText();
                String address= add.getText();
                String phone= ph.getText();
                String mail= email.getText();
                String course= tfCourse.getText();
                String branch= tfBranch.getText();


                String query= "update student set address='"+address+"',phone='"+phone+"',mail='"+mail+"',course='"+course+"',branch='"+branch+"'where rollNum='"+rollNum+"'";

                try{
                    DBConnection connection=new DBConnection();
                    connection.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Student Detail updated Successfully");
                    setVisible(false);

                }catch(Exception e){
                    e.printStackTrace();
                }

            }else{
                setVisible(false);
            }

        }

        public static void main(String[] args) {
            new StudentUpdate();
        }
}
