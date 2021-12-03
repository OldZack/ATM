import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginUI {

    private JFrame frame;
    private JPanel panel;
    private JButton loginButton;
    private JButton backButton;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JPasswordField idField;
    private JPasswordField passwordField;
    private String ID;


    public LoginUI(int identity) {
        if (identity == 1){
            ID = "Customer";
        } else{
            ID = "Manager";
        }
        frame = new JFrame(ID + " Login Board");
        panel = new JPanel();
        idLabel = new JLabel("UserID: ");
        passwordLabel = new JLabel("Password: ");
        idField = new JPasswordField(30);
        passwordField = new JPasswordField(30);
        loginButton = new JButton("Login");
        backButton = new JButton("Back");

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){

        panel.setLayout(null);

        idLabel.setBounds(150,75,100,35);
        passwordLabel.setBounds(150,125,100,35);
        idField.setBounds(250,75,200,35);
        passwordField.setBounds(250,125,200,35);
        loginButton.setBounds(175,250,100,50);
        backButton.setBounds(325,250,100,50);
//        loginButton.setForeground(Color.BLUE);
//        loginButton.setBackground(Color.BLUE);
//        backButton.setForeground(Color.CYAN);

        panel.add(idLabel);
        panel.add(passwordLabel);
        panel.add(idField);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (ID.equalsIgnoreCase("Customer")){
                    new CustomerUI();
                } else{
                    new ManagerUI();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
                new WelcomeUI();
            }
        });
    }
}
