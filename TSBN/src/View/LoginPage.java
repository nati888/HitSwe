package View;


import Controller.*;
import Controller.Exception1.AlreadyExistException;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage  extends JFrame {
        private JPanel panel;
        private JPasswordField passwordField;
        private JLabel userLabel;
        private JTextField userText;
        private JLabel passwordLabel;
        private JButton button;

        private LoginController controller= LoginController.getMySingelton();


        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        LoginPage frame = new LoginPage();
                        frame.setVisible(true);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        public LoginPage(){
            this.setTitle("TSBN inc.");                                      //Frame Title
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
            setBounds(400,100,400,300);                 //Frame size
            panel =new JPanel();
            userLabel=new JLabel("User :");
            userLabel.setBounds(10,20,80,25);
            panel.add(userLabel);

            userText=new JTextField();
            userText.setBounds(100,20,165,25);
            panel.add(userText);

            passwordLabel=new JLabel("password :");
            passwordLabel.setBounds(10,50,80,25);
            panel.add(passwordLabel);

            passwordField=new JPasswordField();
            passwordField.setBounds(100,50,165,25);
            passwordField.setColumns(10);
            panel.add(passwordField);

            button=new JButton("Login");
            button.setBounds(50,100,100,25);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {        //login button
                    boolean success = false;
                    try {      //calls controller with user name and password and recieves boolean if user is valid
                        success = controller.login(userText.getText(), new String(passwordField.getPassword()));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    checkUser(success,userText.getText());      //local function checks if user is valid if true switch to main page else throws pop up with invalid user/password
                }
            });
            panel.add(button);

            GroupLayout layout=new GroupLayout(panel);
            panel.setLayout(layout);
            setContentPane(panel);
        }
        public void checkUser(boolean isValidUser,String userName)
        {
            if(!isValidUser){           //if user is invalid throws pop up with invalid user or password
                JOptionPane.showMessageDialog(null,"User name or password is incorrect");
            }
            else
            {                           //if user is valid throw a welcome pop up and moves to main page
                JOptionPane.showMessageDialog(null,"Welcome "+userName,"Success",1);
                MainPage view=new View.MainPage();
                dispose();
                view.setVisible(true);
            }
        }
}
