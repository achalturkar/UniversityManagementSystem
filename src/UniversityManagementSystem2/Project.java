package UniversityManagementSystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Project extends JFrame implements ActionListener {


    Project(){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1470,750, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        JMenuBar jm = new JMenuBar();
        setJMenuBar(jm);

        //New Information
        JMenu newInformation= new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        jm.add(newInformation);

        JMenuItem faculty= new JMenuItem("New Faculty Information");
        faculty.setBackground(Color.white);
        faculty.setForeground(Color.BLACK);
        faculty.addActionListener(this);
        newInformation.add(faculty);

        JMenuItem student= new JMenuItem("New Student Information");
        faculty.setBackground(Color.white);
        student.setForeground(Color.BLACK);
        student.addActionListener(this);
        newInformation.add(student);

         //Detail
        JMenu detail= new JMenu("Detail");
        detail.setForeground(Color.red);
        jm.add(detail);

        JMenuItem facultyDetail= new JMenuItem("view Faculty Detail");
        facultyDetail.setBackground(Color.white);
        facultyDetail.setForeground(Color.BLACK);
        facultyDetail.addActionListener(this);
        detail.add(facultyDetail);

        JMenuItem studentDetail= new JMenuItem("view Student Detail");
        studentDetail.setBackground(Color.white);
        studentDetail.setForeground(Color.BLACK);
        studentDetail.addActionListener(this);
        detail.add(studentDetail);

        //Leave
        JMenu leave= new JMenu("Leave");
        leave.setForeground(Color.blue);
        jm.add(leave);

        JMenuItem facultyLeave= new JMenuItem("Faculty Leave ");
        facultyLeave.setBackground(Color.white);
        facultyLeave.setForeground(Color.BLACK);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave= new JMenuItem("Student Leave ");
        studentLeave.setBackground(Color.white);
        studentLeave.setForeground(Color.BLACK);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //Leave Detail
        JMenu leaveDetail= new JMenu("Leave Detail");
        leaveDetail.setForeground(Color.red);
        jm.add(leaveDetail);

        JMenuItem facultyLeaveDetail= new JMenuItem("View Faculty Leave Detail");
        facultyLeaveDetail.setBackground(Color.white);
        facultyLeaveDetail.setForeground(Color.BLACK);
        facultyLeaveDetail.addActionListener(this);
        leaveDetail.add(facultyLeaveDetail);

        JMenuItem studentLeaveDetail= new JMenuItem("view Student Leave Detail");
        studentLeaveDetail.setBackground(Color.white);
        studentLeaveDetail.setForeground(Color.BLACK);
        studentLeaveDetail.addActionListener(this);
        leaveDetail.add(studentLeaveDetail);


        //Exam
        JMenu exam= new JMenu("Examination");
        exam.setForeground(Color.blue);
        jm.add(exam);

        JMenuItem examinationDetail= new JMenuItem("Examination Detail");
        examinationDetail.setBackground(Color.white);
        examinationDetail.setForeground(Color.BLACK);
        examinationDetail.addActionListener(this);
        exam.add(examinationDetail);

        JMenuItem enterMarks= new JMenuItem("Enter Student Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.setForeground(Color.BLACK);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        //Update-
       JMenu updateInfo=new JMenu("Update");
       updateInfo.setForeground(Color.red);
       jm.add(updateInfo);

        JMenuItem updateFacultyInfo= new JMenuItem("Update Faculty Information");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.setForeground(Color.BLACK);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo= new JMenuItem("Update Student Information");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.setForeground(Color.BLACK);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //Update-
       JMenu fees=new JMenu("Fees Detail");
       fees.setForeground(Color.blue);
       jm.add(fees);

        JMenuItem studentFees= new JMenuItem("Student Fees Structure");
        studentFees.setBackground(Color.white);
        studentFees.setForeground(Color.BLACK);
        studentFees.addActionListener(this);
        fees.add(studentFees);

        JMenuItem feesForm= new JMenuItem("Student Fees Form");
        feesForm.setBackground(Color.white);
        feesForm.setForeground(Color.BLACK);
        feesForm.addActionListener(this);
        fees.add(feesForm);

        //utility
       JMenu utility=new JMenu("Utility");
       utility.setForeground(Color.red);
       jm.add(utility);

        JMenuItem notepad= new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.setForeground(Color.BLACK);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator= new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.setForeground(Color.BLACK);
        calculator.addActionListener(this);
        utility.add(calculator);

        //About

        JMenu about=new JMenu("About");
        about.setForeground(Color.blue);
        jm.add(about);

        JMenuItem ab= new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.setForeground(Color.BLACK);
        ab.addActionListener(this);
        about.add(ab);


        //Exit-
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.red);
        jm.add(exit);

        JMenuItem ex= new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.setForeground(Color.BLACK);
        ex.addActionListener(this);
        exit.add(ex);

        setTitle("University Work Place");
        setSize(1530,880);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();

            if (msg.equalsIgnoreCase("Exit")) {
                setVisible(false);

            } else if (msg.equalsIgnoreCase("Calculator")) {
               try{
                   Runtime.getRuntime().exec("Calc.exe");
               }catch(Exception e){
                   System.out.println(e.getMessage());
               }

            } else if (msg.equalsIgnoreCase("Notepad")) {
                try{
                    Runtime.getRuntime().exec("Notepad.exe");

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else if (msg.equals("New Faculty Information")) {
                new AddTeacher();
            } else if (msg.equals("New Student Information")) {
                new AddStudent();
            } else if (msg.equals("view Faculty Detail")) {
                new FacultyDetail();
            } else if (msg.equals("view Student Detail")) {
                new StudentDetail();
            }else if(msg.equals("Faculty Leave ")){
                new FacultyLeave();
            } else if (msg.equals("Student Leave ")) {
                new StudentLeave();
            } else if (msg.equals("View Faculty Leave Detail")) {
                new FacultyLeaveDetail();
            } else if (msg.equals("view Student Leave Detail")) {
                new StudentLeaveDetail();
            } else if (msg.equals("Update Faculty Information")) {
                new FacultyUpdate();
            } else if (msg.equals("Update Student Information")) {
                new StudentUpdate();
            } else if (msg.equals("Enter Student Marks")) {
                new EnterMarks();
            } else if (msg.equals("Examination Detail")) {
                new ExaminationDetail();
            }else if (msg.equals("Student Fees Structure")) {
                new FeesStructure();
            }else if (msg.equals("About")) {
                new About();
            } else if (msg.equals("Student Fees Form")) {
                new StudentFeesForm();
            }
    }

    public static void main(String[] args) {
        new Project();
    }
}
