package View;


import Controller.*;
import Controller.Exception1.AlreadyExistException;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateSalaryPage  extends JFrame {
    private JPanel panel;
    private JLabel userLabel;
    private JTextField userText;
    private JButton button;
    private JTextField salaryField;
    private JButton backButton;

    private CalculateSalaryController controller= CalculateSalaryController.getMySingelton();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CalculateSalaryPage frame = new CalculateSalaryPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public CalculateSalaryPage(){
        this.setTitle("TSBN inc.");                                      //Frame Title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
        setBounds(400,100,400,300);                 //Frame size
        panel =new JPanel();
        userLabel=new JLabel("Enter worker's ID:");
        userLabel.setBounds(10,20,120,25);
        panel.add(userLabel);

        userText=new JTextField();
        userText.setBounds(130,20,165,25);
        panel.add(userText);

        salaryField=new JTextField();
        salaryField.setBounds(130,55,165,25);
        salaryField.setEditable(false);
        panel.add(salaryField);

        button=new JButton("Calculate");
        button.setBounds(50,100,100,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    //calculate button sends user ID to controller and recieves boolean back if success
                boolean success = false;
                try {
                    success = controller.checkID(userText.getText()); //checks if user exist
                } catch (AlreadyExistException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkID(success,userText.getText()); //calls local function ,if success is true prints salary

            }
        });
        panel.add(button);

        backButton=new JButton("Back");
        backButton.setBounds(220,220,150,25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        //back button returns the user to main page
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
        if(!isValidId){         //if false throws a pop up ID is not found
            JOptionPane.showMessageDialog(null,"ID "+ id+" is not found");
        }
        else                //if true calls controller with ID and recieves calculated salary
        {
            Object [] salary= (controller.CalculateSalary(id));
            salaryField.setText(String.valueOf(salary[0])); //display the calculated salary back to screen
        }
    }
}
