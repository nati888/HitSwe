package View;


import Controller.*;
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

//        private View.ObservableView observableView = new View.ObservableView();
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
            //observableView.addObserver(/*controller*/);
            this.setTitle("TSBN inc.");                                      //Frame Title
            //this.setSize(1000,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
            setBounds(600,300,600,400);                 //Frame size
            panel =new JPanel();
            //panel.setBorder(new EmptyBorder(5,5,5,5));  //inner panel borders
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
                public void actionPerformed(ActionEvent e) {
//                    observableView.notifyObs(new Object[]{userText.getText(), new String(passwordField.getPassword())});
                    boolean success = controller.login(userText.getText(), new String(passwordField.getPassword()));
                    checkUser(success,userText.getText());

                }
            });
            panel.add(button);

            setContentPane(panel);

            GroupLayout layout=new GroupLayout(panel);
            panel.setLayout(layout);

        }
        public void checkUser(boolean isValidUser,String userName)
        {
            if(!isValidUser){
                JOptionPane.showMessageDialog(null,"User name or password is incorrect");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Welcome "+userName,"Success",1);
                MainPage view=new View.MainPage();
                dispose();
                view.setVisible(true);
            }
        }
}
