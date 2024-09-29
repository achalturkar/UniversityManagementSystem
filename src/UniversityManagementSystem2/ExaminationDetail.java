package UniversityManagementSystem2;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class ExaminationDetail extends JFrame implements ActionListener {


    JTextField jtSearch;

    JButton result, cancel;

    JTable table;


    ExaminationDetail(){

        setLayout(null);
        setTitle("Check Result");
        getContentPane().setBackground(Color.white);

        JLabel checkLable= new JLabel("Check Result");
        checkLable.setBounds(30,20,150,30);
        checkLable.setFont(new Font("ubuntu", Font.BOLD, 20));
        add(checkLable);

        jtSearch = new JTextField();
        jtSearch.setBounds(190,20,150,30);
        add(jtSearch);

        result= new JButton("Result");
        result.setBounds(350,20,100,30);
        result.setFont(new Font("Tahoma", Font.BOLD,15));
        result.setBackground(Color.blue);
        result.setForeground(Color.white);
        result.addActionListener(this);
        add(result);

        cancel= new JButton("Cancel");
        cancel.setBounds(460,20,100,30);
        cancel.setFont(new Font("Tahoma", Font.BOLD,15));
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        table = new JTable();
        table.setBounds(5,70,770,430);

        JScrollPane scroll= new JScrollPane();
        scroll.setBounds(780,70,750,430);
        add(scroll);

        try{
            DBConnection connection= new DBConnection();
            ResultSet rs=connection.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }
        add(table);

        try{
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row= table.getSelectedRow();
                    jtSearch.setText(table.getModel().getValueAt(row,3).toString());
                }

            });

        }catch(Exception e){
            e.printStackTrace();
        }



        setSize(800,500);
        setLocation(300,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==result){
            new Result(jtSearch.getText());
            setVisible(false);

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetail();
    }
}
