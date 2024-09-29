package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){

        setLayout(null);
        setTitle("About");
        setLocation(200,100);
        setSize(800,600);
        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400,50,300,200);
        add(image);



        JLabel head = new JLabel("<html>University <br/> Management <br/> System </html> ");
        head.setBounds(60,20,250,200);
        head.setFont(new Font("Tahoma",Font.BOLD,35));
        head.setForeground(Color.RED);
        add(head);

        JLabel name = new JLabel("Developed By: Achal Turkar");
        name.setBounds(40,280,400,50);
        name.setFont(new Font("Tahoma",Font.BOLD,25));
        name.setForeground(Color.BLACK);
        add(name);

        JLabel rolln = new JLabel("Roll Number: 01");
        rolln.setBounds(40,330,400,50);
        rolln.setFont(new Font("Tahoma",Font.BOLD,25));
        rolln.setForeground(Color.BLACK);
        add(rolln);


        setVisible(true);
    }


    public static void main(String[] args) {
        new About();
    }
}
