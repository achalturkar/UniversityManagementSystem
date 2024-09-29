package UniversityManagementSystem2;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField textName, textFName, textSName,add, ph, email, perX, perXII, aadhar;
    JLabel empId;
    JDateChooser dobC;
    JComboBox qualificationCombo, deptCombo;

    JButton submit, cancel;
    Random random= new Random();
    long ranNo= Math.abs((random.nextLong()%9000L)+ 1000L);
    AddTeacher(){
        setTitle("Faculty Teacher");
        setLayout(null);
        setLocation(400,100);
        setSize(800,600);

        JLabel head = new JLabel("New Faculty Detail");
        head.setBounds(250,30,400,40);
        head.setFont(new Font("serif",Font.BOLD, 30));
        add(head);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30,100,80,30);
        nameLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(nameLabel);

        textName = new JTextField();
        textName.setBounds(120,100,200,30);
        add(textName);

        JLabel nameFLabel = new JLabel("Father Name");
        nameFLabel.setBounds(350,100,150,30);
        nameFLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(nameFLabel);

        textFName = new JTextField();
        textFName.setBounds(500,100,200,30);
        add(textFName);

        JLabel surnameLabel = new JLabel("surname");
        surnameLabel.setBounds(30,150,80,30);
        surnameLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(surnameLabel);

        textSName = new JTextField();
        textSName.setBounds(120,150,200,30);
        add(textSName);

        JLabel emp = new JLabel("EmpId");
        emp.setBounds(30,200,120,30);
        emp.setFont(new Font("serif",Font.BOLD, 18));
        add(emp);

        empId = new JLabel("101"+ ranNo);
        empId.setBounds(160,200,150,30);
        empId.setFont(new Font("serif",Font.BOLD, 18));
        add(empId);

        JLabel dobLabel = new JLabel("Date Of Birth");
        dobLabel.setBounds(350,200,120,30);
        dobLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(dobLabel);

        dobC = new JDateChooser();
        dobC.setBounds(500,200,120,30);
        add(dobC);

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

        perX = new JTextField();
        perX.setBounds(500,300,200,30);
        add(perX);

        JLabel perXIILabel = new JLabel("12th%");
        perXIILabel.setBounds(30,350,150,30);
        perXIILabel.setFont(new Font("serif",Font.BOLD, 18));
        add(perXIILabel);

        perXII = new JTextField();
        perXII.setBounds(120,350,200,30);
        add(perXII);

        JLabel aadharLabel = new JLabel("Aadhar No.");
        aadharLabel.setBounds(350,350,150,30);
        aadharLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(aadharLabel);

        aadhar = new JTextField();
        aadhar.setBounds(500,350,200,30);
        add(aadhar);

        JLabel qualiLabel = new JLabel("Education");
        qualiLabel.setBounds(30,400,150,30);
        qualiLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(qualiLabel);

        String qualificaion[]={"B.Tech","BBA","BCA","Bsc","Bcom","M.Tech","MBA","MCA","MA", "BA", "PHD"};
        qualificationCombo = new JComboBox(qualificaion);
        qualificationCombo.setBounds(120, 400,200,30);
        add(qualificationCombo);

        JLabel deparLabel = new JLabel("Department");
        deparLabel.setBounds(350,400,150,30);
        deparLabel.setFont(new Font("serif",Font.BOLD, 18));
        add(deparLabel);

        String depar[]={"Computer Science","IT","Cyber Security","Electrical","Mechanical","Electronics","Finance","Marketing"};
        deptCombo = new JComboBox(depar);
        deptCombo.setBounds(500, 400,200,30);
        add(deptCombo);

        submit = new JButton("Submit");
        submit.setBounds(200,480, 100, 40);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("ubuntu",Font.BOLD, 15));

        submit.addActionListener(this);
        add(submit);

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

        if(ae.getSource()==submit){
            String fName=textName.getText();
            String midName= textFName.getText();
            String lastName= textSName.getText();
            String employeeID = empId.getText();
            String dob= ((JTextField)dobC.getDateEditor().getUiComponent()).getText();
            String address= add.getText();
            String phone= ph.getText();
            String mail= email.getText();
            String tenPer= perX.getText();
            String twelvePer= perXII.getText();
            String aadharNum= aadhar.getText();
            String qualification= (String) qualificationCombo.getSelectedItem();
            String department= (String) deptCombo.getSelectedItem();


            String query= "insert into teacher values('" +fName+"','"+midName+"','"+lastName+
                    "','"+employeeID+"','"+dob+"','"+address+"','"+phone+"','"+mail+"','"+tenPer+
                    "','"+twelvePer+"','"+aadharNum+"','"+qualification+"','"+department + "')"+"";

            try{
                DBConnection connection=new DBConnection();
                connection.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Faculty Detail Inserted Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
