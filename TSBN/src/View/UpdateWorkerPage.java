package View;

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
    private AddWorkerController controller= AddWorkerController.getMySingelton();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    AddWorkerPage frame=new AddWorkerPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void updateWorkerPage(Worker worker)

    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 500);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("TSBN .inc");

        lastNameLabel=new JLabel("Last name: ");
        lastNameLabel.setBounds(10,20,80,25);
        panel.add(lastNameLabel);
        lastNameField=new JTextField(worker.getLast_name());
        lastNameField.setBounds(100,20,165,25);
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
//                   observableView.notifyObs(new Object[]{lastNameField.getText(),firstNameField.getText(),IDField.getText(),mailField.getText(),departmentField.getText(),jobField.getText(),experienceField.getText(),baseSalaryField.getText(),userNameField.getText(),passwordField.getText()});
                boolean success = false;
                try {
                    success = controller.add(lastNameField.getText(),firstNameField.getText(),IDField.getText(),mailField.getText(),departmentField.getText(),jobField.getText(),experienceField.getText(),baseSalaryField.getText(),userNameField.getText(),passwordField.getText());
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
