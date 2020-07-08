package View;

import Controller.DeleteWorkerController;
import Controller.Exception1.AlreadyExistException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeletePage extends JFrame {
    private JPanel panel;
    private JLabel userIDLabel;
    private JTextField userIDField;
    private JButton deletebutton;
    private JButton backButton;
    private DeleteWorkerController controller= DeleteWorkerController.getMySingelton();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    DeletePage frame=new DeletePage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public DeletePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,100,400,300);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("TSBN .inc");

        userIDLabel = new JLabel("Enter worker's ID: ");
        userIDLabel.setBounds(10, 20, 120, 25);
        panel.add(userIDLabel);

        userIDField = new JTextField();
        userIDField.setBounds(115, 20, 165, 25);
        panel.add(userIDField);

        deletebutton = new JButton("Delete");
        deletebutton.setBounds(50, 70, 125, 25);
        deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean successDelete = false;
                try {
                    successDelete = controller.delete(userIDField.getText());  //calls controller with ID field, deletes worker and recieves boolean
                } catch (IOException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkUser(successDelete,userIDField.getText());// local function checks if delete was successful
            }
        });
        panel.add(deletebutton);

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

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        setContentPane(panel);
    }

    public void checkUser(boolean isValidUser,String id){
        if(!isValidUser){               //if false throws a pop up worker doesn't exist
            JOptionPane.showMessageDialog(null,"Worker "+ id+ " does not exist");
        }
        else{                  // if true throws pop up worker deleted and change pages to main page
            JOptionPane.showMessageDialog(null,"Worker ID:  "+id+" deleted"," deleted",1);
            MainPage view=new View.MainPage();
            dispose();
            view.setVisible(true);
        }
    }
}