import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeUI {

    private JFrame frame;
    private JPanel panel;
    private JButton customerButton;
    private JButton managerButton;
    private JButton exitButton;
    private JLabel welcomeLabel;
    private JLabel identityLabel;

    public WelcomeUI() {
        frame = new JFrame("Welcome Board");
        panel = new JPanel();
        welcomeLabel = new JLabel("Welcome");
        customerButton = new JButton("Customer");
        managerButton = new JButton("Manager");
        exitButton = new JButton("Exit");
        welcomeLabel = new JLabel("Welcome to the online ATM system!");
        identityLabel = new JLabel("Please select your identity.");

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){

        panel.setLayout(null);

        welcomeLabel.setBounds(200,50,300,100);
        identityLabel.setBounds(225,75,300,100);
        customerButton.setBounds(150,200,100,50);
        managerButton.setBounds(250,200,100,50);
        exitButton.setBounds(350,200,100,50);

        panel.add(welcomeLabel);
        panel.add(identityLabel);
        panel.add(customerButton);
        panel.add(managerButton);
        panel.add(exitButton);


        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Customer Login
                frame.dispose();
                new LoginUI(1);
            }
        });

        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Manager Login
                frame.dispose();
                new LoginUI(2);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
