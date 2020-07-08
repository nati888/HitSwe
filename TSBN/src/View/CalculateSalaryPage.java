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
        //observableView.addObserver(/*controller*/);
        this.setTitle("TSBN inc.");                                      //Frame Title
        //this.setSize(1000,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //Frame closing setup
        setBounds(400,100,400,300);                 //Frame size
        panel =new JPanel();
        //panel.setBorder(new EmptyBorder(5,5,5,5));  //inner panel borders
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
            public void actionPerformed(ActionEvent e) {
                // observableView.notifyObs(new Object[]{userText.getText(), new String(passwordField.getPassword())});
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
            Object [] salary= (controller.CalculateSalary(id));
            salaryField.setText(String.valueOf(salary[0]));

        }
    }
}
