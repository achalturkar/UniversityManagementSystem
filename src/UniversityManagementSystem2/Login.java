package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login;
    JButton cancel;
    JTextField tfUserName;
    JPasswordField jPass;
    Login(){

        setTitle("Login");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lUserName = new JLabel("Username");
        lUserName.setBounds(30,20,70,20);
        add(lUserName);

        tfUserName=new JTextField();
        tfUserName.setBounds(110, 20, 110,20);
        add(tfUserName);

        JLabel lPassword = new JLabel("Password");
        lPassword.setBounds(30,50,70,20);
        add(lPassword);

         jPass = new JPasswordField();
        jPass.setBounds(110,50, 110,20);
        add(jPass);

         login=new JButton("Login");
        login.setBounds(30, 90, 90, 20);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahona", Font.BOLD, 15));
        add(login);

         cancel=new JButton("Cancel");
        cancel.setBounds(130, 90, 90, 20);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahona", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(230, 0, 130, 130);
        add(image);

        setSize(400,300);
        setLocation(500,250);
        setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String userName= tfUserName.getText();
            String password= jPass.getText();
            String query= "select * from login where username='"+userName + "'and password='"+ password+"'" +
                    "";
            try{
            DBConnection connection= new DBConnection();
               ResultSet rs= connection.s.executeQuery(query);

               if(rs.next()){
                  setVisible(false);
                   new Project();
               }else{
                   JOptionPane.showMessageDialog(null,"you Entered invalid username and password");
               }

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args) {
       new Login();
    }
}
