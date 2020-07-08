package View;


import Controller.*;
import Controller.Exception1.AlreadyExistException;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchingWorkerPage  extends JFrame {
    private JPanel panel;
    private JLabel userLabel;
    private JTextField userText;
    private JButton searchButton;
    private JButton backButton;

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


    private UpdateSearchWorkerController controller = UpdateSearchWorkerController.getMySingelton();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SearchingWorkerPage frame = new SearchingWorkerPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchingWorkerPage() {
        this.setTitle("TSBN inc.");                                      //Frame Title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
        setBounds(400,100, 500, 500);                 //Frame size
        panel = new JPanel();
        userLabel = new JLabel("Enter worker's ID:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);


        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(10, 60, 80, 25);
        panel.add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setBounds(130, 60, 165, 25);
        lastNameField.setEditable(false);
        panel.add(lastNameField);

        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(10, 90, 80, 25);
        panel.add(firstNameLabel);
        firstNameField = new JTextField();
        firstNameField.setBounds(130, 90, 165, 25);
        firstNameField.setEditable(false);
        panel.add(firstNameField);

        IDLAbel = new JLabel("ID: ");
        IDLAbel.setBounds(10, 120, 80, 25);
        panel.add(IDLAbel);
        IDField = new JTextField();
        IDField.setBounds(130, 120, 165, 25);
        IDField.setEditable(false);
        panel.add(IDField);

        mailLabel = new JLabel("Mail: ");
        mailLabel.setBounds(10, 150, 80, 25);
        panel.add(mailLabel);
        mailField = new JTextField();
        mailField.setBounds(130, 150, 165, 25);
        mailField.setEditable(false);
        panel.add(mailField);

        departmentLabel = new JLabel("Departemnt ID: ");
        departmentLabel.setBounds(10, 180, 500, 25);
        panel.add(departmentLabel);
        departmentField = new JTextField();
        departmentField.setBounds(130, 180, 165, 25);
        departmentField.setEditable(false);
        panel.add(departmentField);

        jobLabel = new JLabel("Job ID: ");
        jobLabel.setBounds(10, 210, 80, 25);
        panel.add(jobLabel);
        jobField = new JTextField();
        jobField.setBounds(130, 210, 165, 25);
        jobField.setEditable(false);
        panel.add(jobField);

        experienceLabel = new JLabel("Experience ID: ");
        experienceLabel.setBounds(10, 240, 500, 25);
        panel.add(experienceLabel);
        experienceField = new JTextField();
        experienceField.setBounds(130, 240, 165, 25);
        experienceField.setEditable(false);
        panel.add(experienceField);

        baseSalaryLabel = new JLabel("Base Salary: ");
        baseSalaryLabel.setBounds(10, 270, 80, 25);
        panel.add(baseSalaryLabel);
        baseSalaryField = new JTextField();
        baseSalaryField.setBounds(130, 270, 165, 25);
        baseSalaryField.setEditable(false);
        panel.add(baseSalaryField);

        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setBounds(10, 300, 80, 25);
        panel.add(userNameLabel);
        userNameField = new JTextField();
        userNameField.setBounds(130, 300, 165, 25);
        userNameField.setEditable(false);
        panel.add(userNameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 330, 80, 25);
        panel.add(passwordLabel);
        passwordField = new JTextField();
        passwordField.setBounds(130, 330, 165, 25);
        passwordField.setEditable(false);
        panel.add(passwordField);

        backButton=new JButton("Back");
        backButton.setBounds(350,330,120,25);

        searchButton = new JButton("Search");
        searchButton.setBounds(350, 20, 120, 25);


        userText = new JTextField();
        userText.setBounds(130, 20, 165, 25);
        panel.add(userText);

        backButton.addActionListener(new ActionListener() {            //back button returns the user to main page
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage view=new View.MainPage();
                dispose();
                view.setVisible(true);
            }
        });
        panel.add(backButton);

        searchButton.addActionListener(new ActionListener() {       //search button finds the worker by ID and returns it to page
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = false;
                try {
                    success = controller.checkID(userText.getText());
                } catch (AlreadyExistException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkID(success, userText.getText());

            }
        });
        panel.add(searchButton);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        setContentPane(panel);
    }

    public void checkID(boolean isValidId, String id) {
        if (!isValidId) {
            JOptionPane.showMessageDialog(null, "ID " + id + " is not found");
        }else
        {
            Object[] worker = controller.getWorker(userText.getText());     //calls controller and finds if workers exist
            lastNameField.setText((String) worker[0]);  //print to user last name field
            firstNameField.setText((String) worker[1]); //print to user first name field
            IDField.setText(String.valueOf(worker[2])); //print to user ID field
            mailField.setText((String) worker[3]);      //print to user mail field
            departmentField.setText(String.valueOf(worker[4])); //print to user department field
            jobField.setText(String.valueOf(worker[5]));    //print to user job ID field
            experienceField.setText(String.valueOf(worker[6])); //print to user experience field
            baseSalaryField.setText(String.valueOf(worker[7])); //print to user base salary field
            userNameField.setText((String) worker[8]);  //print to user user name field
            passwordField.setText((String) worker[9]);  //print to user password field
        }
    }
}