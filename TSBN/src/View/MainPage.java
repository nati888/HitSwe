package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
        private JPanel panel;
        private JLabel introText;
        private JButton addWorkerButton;
        private JButton deleteWorkerButton;
        private JButton calculateSalaryButton;
        private JButton UpdateWorkerPageButton;
        private JButton findWorkerButton;
        private JButton logOutButton;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try{
                        MainPage frame=new MainPage();
                        frame.setVisible(true);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

        public MainPage(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(400,100,500,500);
            panel=new JPanel();
            panel.setBorder(new EmptyBorder(5,5,5,5));
            setTitle("TSBN .inc");

            introText=new JLabel("Hello",JLabel.CENTER);
            introText.setVerticalAlignment(JLabel.TOP);
            introText.setFont(new Font("Verdana", Font.ITALIC, 50));
            introText.setPreferredSize(new Dimension(250, 100));
            introText.setBounds(130,20,200,200);
            panel.add(introText);

            addWorkerButton=new JButton("Add");
            addWorkerButton.setBounds(50,200,100,25);
            addWorkerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //  JOptionPane.showMessageDialog(null,"","Success",1);
                    AddWorkerPage view=new AddWorkerPage();
                    dispose();
                    view.setVisible(true);
                }
            });
            panel.add(addWorkerButton);

            deleteWorkerButton=new JButton("Delete");
            deleteWorkerButton.setBounds(175,200,100,25);
            deleteWorkerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeletePage view=new DeletePage();
                    dispose();
                    view.setVisible(true);

                }
            });
            panel.add(deleteWorkerButton);

            findWorkerButton=new JButton("Find Worker");
            findWorkerButton.setBounds(300,200,150,25);
            findWorkerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchingWorkerPage view=new SearchingWorkerPage();
                    dispose();
                    view.setVisible(true);
                }
            });
            panel.add(findWorkerButton);

            calculateSalaryButton=new JButton("Calculate salary");
            calculateSalaryButton.setBounds(50,250,150,25);
            calculateSalaryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CalculateSalaryPage view=new CalculateSalaryPage();
                    dispose();
                    view.setVisible(true);

                }
            });

            panel.add(calculateSalaryButton);
            logOutButton=new JButton("Log Out");
            logOutButton.setBounds(300,400,150,25);
            logOutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginPage view=new LoginPage();
                    dispose();
                    view.setVisible(true);

                }
            });
            panel.add(logOutButton);
            UpdateWorkerPageButton=new JButton("Update Worker");
            UpdateWorkerPageButton.setBounds(225,250,150,25);
            UpdateWorkerPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateWorkerPage view=new UpdateWorkerPage();
                    dispose();
                    view.setVisible(true);

                }
            });
            panel.add(UpdateWorkerPageButton);



            setContentPane(panel);
            GroupLayout layout=new GroupLayout(panel);
            panel.setLayout(layout);

        }
}
