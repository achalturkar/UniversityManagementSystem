package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FacultyUpdate extends JFrame implements ActionListener {


        JTextField tfQuali, tfDept, add, ph, email ;
        JLabel empId;

        JButton update, cancel;
        Choice cEmpId;

        FacultyUpdate(){
            setTitle("Update Faculty");
            setLayout(null);
            setLocation(400,100);
            setSize(800,600);

            JLabel head = new JLabel("Update Faculty Detail");
            head.setBounds(40,10,400,40);
            head.setFont(new Font("serif",Font.BOLD, 30));
            add(head);

            JLabel label = new JLabel("Search Faculty For Update");
            label.setBounds(20,60,230,30);
            label.setFont(new Font("ubuntu", Font.BOLD, 15));
            add(label);

            cEmpId= new Choice();
            cEmpId.setBounds(260,60,280,30);
            add(cEmpId);

            try{
                DBConnection connection= new DBConnection();
                ResultSet rs=connection.s.executeQuery("Select * from Teacher");
                while(rs.next()){
                    cEmpId.add(rs.getString("employeeID"));
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

            JLabel empLabel = new JLabel("Employee ID");
            empLabel.setBounds(30,200,120,30);
            empLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(empLabel);

            empId = new JLabel();
            empId.setBounds(160,200,150,30);
            empId.setFont(new Font("serif",Font.BOLD, 18));
            add(empId);

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

            JLabel eduLabel = new JLabel("Education");
            eduLabel.setBounds(30,400,150,30);
            eduLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(eduLabel);

            tfQuali = new JTextField();
            tfQuali.setBounds(120, 400,200,30);
            add(tfQuali);

            JLabel deLabel = new JLabel("Department");
            deLabel.setBounds(350,400,150,30);
            deLabel.setFont(new Font("serif",Font.BOLD, 18));
            add(deLabel);

            tfDept = new JTextField();
            tfDept.setBounds(500, 400,200,30);
            add(tfDept);

            try {
                DBConnection connection= new DBConnection();
                String query= "select * from Teacher where employeeID='"+cEmpId.getSelectedItem()+"'";
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
                    empId.setText(rs.getString("employeeID"));
                    tfDept.setText(rs.getString("department"));
                    tfQuali.setText(rs.getString("qualification"));
                }


            }catch (Exception e){
                e.printStackTrace();
            }

            cEmpId.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {
                        DBConnection connection= new DBConnection();
                        String query= "select * from Teacher where employeeID='"+cEmpId.getSelectedItem()+"'";
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
                            empId.setText(rs.getString("employeeID"));
                            tfDept.setText(rs.getString("department"));
                            tfQuali.setText(rs.getString("qualification"));
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


                String employeeId = empId.getText();
                String address= add.getText();
                String phone= ph.getText();
                String mail= email.getText();
                String qualification= tfQuali.getText();
                String department= tfDept.getText();


                String query= "update teacher set address='"+address+"',phone='"+phone+"',mail='"+mail+"',qualification='"+qualification+"',department='"+department+"'where employeeID='"+employeeId+"'";

                try{
                    DBConnection connection=new DBConnection();
                    connection.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Faculty Detail updated Successfully");
                    setVisible(false);

                }catch(Exception e){
                    e.printStackTrace();
                }

            }else{
                setVisible(false);
            }

        }

        public static void main(String[] args) {
            new FacultyUpdate();
        }

}
