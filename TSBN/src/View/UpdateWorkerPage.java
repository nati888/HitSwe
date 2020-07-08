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
    private JButton searchButton;

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
    private JTextField experienceField;
    private JTextField baseSalaryField;
    private JTextField userNameField;
    private JTextField passwordField;

    private  JButton updateButton;
    private  JButton backButton;

    private UpdateSearchWorkerController controller= UpdateSearchWorkerController.getMySingelton();


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
        setBounds(400,100, 500, 500);                 //Frame size
        panel =new JPanel();
        userLabel=new JLabel("Enter worker's ID:");
        userLabel.setBounds(10,20,120,25);
        panel.add(userLabel);


        lastNameLabel=new JLabel("Last Name: ");
        lastNameLabel.setBounds(10,60,80,25);
        panel.add(lastNameLabel);

        lastNameField=new JTextField();
        lastNameField.setBounds(130,60,165,25);
        lastNameField.setEditable(false);
        panel.add(lastNameField);

        firstNameLabel=new JLabel("First Name: ");
        firstNameLabel.setBounds(10,90,80,25);
        panel.add(firstNameLabel);

        firstNameField=new JTextField();
        firstNameField.setBounds(130,90,165,25);
        firstNameField.setEditable(false);
        panel.add(firstNameField);

        IDLAbel=new JLabel("ID: ");
        IDLAbel.setBounds(10,120,80,25);
        panel.add(IDLAbel);

        IDField=new JTextField();
        IDField.setBounds(130,120,165,25);
        IDField.setEditable(false);
        panel.add(IDField);

        mailLabel=new JLabel("Mail: ");
        mailLabel.setBounds(10,150,80,25);
        panel.add(mailLabel);

        mailField=new JTextField();
        mailField.setBounds(130,150,165,25);
        panel.add(mailField);

        departmentLabel=new JLabel("Departemnt ID: ");
        departmentLabel.setBounds(10,180,500,25);
        panel.add(departmentLabel);

        departmentField=new JTextField();
        departmentField.setBounds(130,180,165,25);
        panel.add(departmentField);

        jobLabel=new JLabel("Job ID: ");
        jobLabel.setBounds(10,210,80,25);
        panel.add(jobLabel);

        jobField=new JTextField();
        jobField.setBounds(130,210,165,25);
        panel.add(jobField);

        experienceLabel=new JLabel("Experience: ");
        experienceLabel.setBounds(10,240,500,25);
        panel.add(experienceLabel);

        experienceField=new JTextField();
        experienceField.setBounds(130,240,165,25);
        panel.add(experienceField);

        baseSalaryLabel=new JLabel("Base Salary: ");
        baseSalaryLabel.setBounds(10,270,80,25);
        panel.add(baseSalaryLabel);

        baseSalaryField=new JTextField();
        baseSalaryField.setBounds(130,270,165,25);
        panel.add(baseSalaryField);

        userNameLabel=new JLabel("User Name: ");
        userNameLabel.setBounds(10,300,80,25);
        panel.add(userNameLabel);

        userNameField=new JTextField();
        userNameField.setBounds(130,300,165,25);
        panel.add(userNameField);

        passwordLabel=new JLabel("Password: ");
        passwordLabel.setBounds(10,330,80,25);
        panel.add(passwordLabel);

        passwordField=new JTextField();
        passwordField.setBounds(130,330,165,25);
        panel.add(passwordField);

        userText=new JTextField();
        userText.setBounds(130,20,165,25);
        panel.add(userText);

        updateButton=new JButton("Update");
        updateButton.setBounds(350,330,120,25);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    //
                boolean success = false;
                try {
                    success = controller.UpdateWorker(lastNameField.getText() ,firstNameField.getText(),IDField.getText(), mailField.getText(),departmentField.getText(),jobField.getText(), experienceField.getText(),baseSalaryField.getText(), userNameField.getText(),passwordField.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                checkUpdate(success);
            }
        });
        panel.add(updateButton);

        searchButton=new JButton("Search");
        searchButton.setBounds(350,20,120,25);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = false;
                try {       //checks if worker ID is valid
                    success = controller.checkID(userText.getText());
                } catch (AlreadyExistException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkID(success,userText.getText());
            }
        });
        panel.add(searchButton);

        backButton=new JButton("Back");
        backButton.setBounds(320,420,150,25);
        backButton.addActionListener(new ActionListener() {      //back button returns the user to main page
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage view=new MainPage();
                dispose();
                view.setVisible(true);
            }
        });
        panel.add(backButton);

        GroupLayout layout=new GroupLayout(panel);
        panel.setLayout(layout);
        setContentPane(panel);
    }
    public void checkID(boolean isValidId,String id) {
        if (!isValidId) {
            JOptionPane.showMessageDialog(null, "ID " + id + " is not found");
        } else {
            Object[] worker = controller.getWorker(userText.getText()); //update worker
            lastNameField.setText((String) worker[0]);
            firstNameField.setText((String) worker[1]);
            IDField.setText(String.valueOf(worker[2]));
            mailField.setText((String) worker[3]);
            departmentField.setText(String.valueOf(worker[4]));
            jobField.setText(String.valueOf(worker[5]));
            experienceField.setText(String.valueOf(worker[6]));
            baseSalaryField.setText(String.valueOf(worker[7]));
            userNameField.setText((String) worker[8]);
            passwordField.setText((String) worker[9]);
        }
    }
    public void checkUpdate(boolean isUpdate) {
        if (!isUpdate) {    //if update was successful prints success and moves to main page
            JOptionPane.showMessageDialog(null, "Invalid paramters,please check again" );
            Object[] worker = controller.getWorker(userText.getText());
            lastNameField.setText((String) worker[0]);
            firstNameField.setText((String) worker[1]);
            IDField.setText(String.valueOf(worker[2]));
            mailField.setText((String) worker[3]);
            departmentField.setText(String.valueOf(worker[4]));
            jobField.setText(String.valueOf(worker[5]));
            experienceField.setText(String.valueOf(worker[6]));
            baseSalaryField.setText(String.valueOf(worker[7]));
            userNameField.setText((String) worker[8]);
            passwordField.setText((String) worker[9]);
        } else {
            JOptionPane.showMessageDialog(null,"Success!","Success",1);
            MainPage view=new View.MainPage();
            dispose();
            view.setVisible(true);
        }
    }
}
