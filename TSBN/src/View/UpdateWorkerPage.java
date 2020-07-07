/*package View;

import Controller.*;
import Controller.Exception1.AlreadyExistException;
import Model.Worker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class UpdateWorkerPage extends JFrame {
    private JPanel panel;
    private JLabel userLable;
    private JTextField userText;
    private  JButton searchButton;


    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel IDLAbel;
    private JLabel mailLabel;
    private JLabel departmentLabel;
    private JLabel jobLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel experienceLabel;
    private JLabel baseSalaryLabel;

    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField IDField;
    private JTextField mailField;
    private JTextField departmentField;
    private JTextField jobField;
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField experienceField;
    private JTextField baseSalaryField;
    private  JButton submitButton;
    private CalculateSalaryController controller= CalculateSalaryController.getMySingelton();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    UpdateWorkerPage frame=new UpdateWorkerPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void UpdateWorkerPage(Worker worker)

    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 500);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("TSBN .inc");

        userLable = new JLabel("Enter worker's ID: ");
        userLable.setBounds(10, 20, 120, 25);
        panel.add(userLable);
        userText = new JTextField();
        userText.setBounds(115, 20, 165, 25);
        panel.add(userText);
        searchButton = new JButton("Search");
        searchButton.setBounds(50, 70, 125, 25);

        lastNameLabel=new JLabel("Last name: ");
        lastNameLabel.setBounds(10,40,80,25);
        panel.add(lastNameLabel);
        lastNameField=new JTextField(worker.getLast_name());
        lastNameField.setBounds(100,40,165,25);
        panel.add(lastNameField);

        firstNameLabel=new JLabel("First name: ");
        firstNameLabel.setBounds(10,55,80,25);
        panel.add(firstNameLabel);
        firstNameField=new JTextField(worker.getFirst_name());
        firstNameField.setBounds(100,55,165,25);
        panel.add(firstNameField);

        IDLAbel=new JLabel("ID: ");
        IDLAbel.setBounds(10,90,80,25);
        panel.add(IDLAbel);
        IDField=new JTextField(worker.getIDperson());
        IDField.setBounds(100,90,165,25);
        panel.add(IDField);

        mailLabel=new JLabel("Email: ");
        mailLabel.setBounds(10,125,80,25);
        panel.add(mailLabel);
        mailField=new JTextField(worker.getMail());
        mailField.setBounds(100,125,165,25);
        panel.add(mailField);

        departmentLabel=new JLabel("Department: ");
        departmentLabel.setBounds(10,160,80,25);
        panel.add(departmentLabel);
        departmentField=new JTextField(worker.getDepartment_ID());
        departmentField.setBounds(100,160,165,25);
        panel.add(departmentField);

        jobLabel=new JLabel("Job: ");
        jobLabel.setBounds(10,195,80,25);
        panel.add(jobLabel);
        jobField=new JTextField(worker.getJob_ID());
        jobField.setBounds(100,195,165,25);
        panel.add(jobField);

        userNameLabel=new JLabel("User name: ");
        userNameLabel.setBounds(10,230,80,25);
        panel.add(userNameLabel);
        userNameField=new JTextField(worker.getUser_name());
        userNameField.setBounds(100,230,165,25);
        panel.add(userNameField);

        passwordLabel=new JLabel("password: ");
        passwordLabel.setBounds(10,265,80,25);
        panel.add(passwordLabel);
        passwordField=new JTextField(worker.getPassword());
        passwordField.setBounds(100,265,165,25);
        panel.add(passwordField);

        experienceLabel=new JLabel("Experience: ");
        experienceLabel.setBounds(10,300,80,25);
        panel.add(experienceLabel);
        experienceField=new JTextField((int) worker.getExperience());
        experienceField.setBounds(100,300,165,25);
        panel.add(experienceField);

        baseSalaryLabel=new JLabel("Base Salary: ");
        baseSalaryLabel.setBounds(10,335,80,25);
        panel.add(baseSalaryLabel);
        baseSalaryField=new JTextField((int) worker.getBase_Salary());
        baseSalaryField.setBounds(100,335,165,25);
        panel.add(baseSalaryField);

        submitButton= new JButton("Submit");
        submitButton.setBounds(50,385,125,25);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = false;
                try {
                 //   success = controller.checkID(lastNameField.getText(),firstNameField.getText(),IDField.getText(),mailField.getText(),departmentField.getText(),jobField.getText(),experienceField.getText(),baseSalaryField.getText(),userNameField.getText(),passwordField.getText());
                      success=controller.checkID(userText.getText());
                } catch (AlreadyExistException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }

                if (success) {
                    JOptionPane.showMessageDialog(null, "Worker has been added successfully! ", "Success", 1);
                    MainPage view = new MainPage();
                    dispose();
                    view.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid!");
                }
            }
        });
        panel.add(submitButton);
        setContentPane(panel);
        GroupLayout layout=new GroupLayout(panel);
        panel.setLayout(layout);

    }
}

*/

package View;


import Controller.*;
import Controller.Exception1.AlreadyExistException;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateWorkerPage  extends JFrame {
    private JPanel panel;
    private JLabel userLabel;
    private JTextField userText;
    private JButton button;

    private JTextField lastName;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel IDLAbel;
    private JLabel mailLabel;
    private JLabel departmentLabel;
    private JLabel jobLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel experienceLabel;
    private JLabel baseSalaryLabel;

    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField IDField;
    private JTextField mailField;
    private JTextField departmentField;
    private JTextField jobField;
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField experienceField;
    private JTextField baseSalaryField;
    private  JButton updateButton;

    private UpdateWorkerController controller= UpdateWorkerController.getMySingelton();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UpdateWorkerPage frame = new UpdateWorkerPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public UpdateWorkerPage(){
        this.setTitle("TSBN inc.");                                      //Frame Title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
        setBounds(600,300,600,400);                 //Frame size
        panel =new JPanel();
        userLabel=new JLabel("Enter worker's ID:");
        userLabel.setBounds(10,20,120,25);
        panel.add(userLabel);

        lastNameField=new JTextField();
        lastNameField.setBounds(130,60,165,25);
        panel.add(lastNameField);

        firstNameField=new JTextField();
        firstNameField.setBounds(130,90,165,25);
        panel.add(firstNameField);

        IDField=new JTextField();
        IDField.setBounds(130,120,165,25);
        panel.add(IDField);

        mailField=new JTextField();
        mailField.setBounds(130,150,165,25);
        panel.add(mailField);


        button=new JButton("Search");
        button.setBounds(50,100,100,25);

        userText=new JTextField();
        userText.setBounds(130,20,165,25);
        panel.add(userText);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = false;
                try {
                    success = controller.checkID(userText.getText());
                } catch (AlreadyExistException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkID(success,userText.getText());

            }
        });
        panel.add(button);

        setContentPane(panel);

        GroupLayout layout=new GroupLayout(panel);
        panel.setLayout(layout);

    }
    public void checkID(boolean isValidId,String id)
    {
        if(!isValidId){
            JOptionPane.showMessageDialog(null,"ID "+ id+" is not found");
        }
        else
        {
            Object[] worker= controller.getWorker(userText.getText());


            lastNameField.setText((String) worker[0]);
            firstNameField.setText((String) worker[1]);
            IDField.setText((String) worker[2]);
            mailField.setText((String) worker[3]);
            departmentField.setText((String) worker[4]);
            jobField.setText((String) worker[5]);
            experienceField.setText((String) worker[6]);
            baseSalaryField.setText((String) worker[7]);
            userNameField.setText((String) worker[8]);
            passwordField.setText((String) worker[9]);



        }
    }
}
