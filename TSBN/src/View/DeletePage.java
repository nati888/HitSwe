package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeletePage extends JFrame {
        private JPanel panel;
        private JLabel userIDLabel;
        private JTextField userIDField;
        private JButton deletebutton;


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
            setBounds(800, 100, 500, 300);
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
                }
            });
            panel.add(deletebutton);


            setContentPane(panel);
            GroupLayout layout = new GroupLayout(panel);
            panel.setLayout(layout);

        }
}
