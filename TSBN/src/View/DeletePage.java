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
                    successDelete = controller.delete(userIDField.getText());
                } catch (IOException alreadyExistException) {
                    alreadyExistException.printStackTrace();
                }
                checkUser(successDelete,userIDField.getText());

            }
        });
        panel.add(deletebutton);


        setContentPane(panel);
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

    }
    public void checkUser(boolean isValidUser,String id)
    {
        if(!isValidUser){
            JOptionPane.showMessageDialog(null,"Worker "+ id+ " does not exist");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Worker ID:  "+id+" deleted"," deleted",1);
            MainPage view=new View.MainPage();
            dispose();
            view.setVisible(true);
        }
    }
}