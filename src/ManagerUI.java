import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel textLabel;
    private JButton viewClientButton;
    private JButton dailyReportButton;
    private JButton logOutButton;

    public ManagerUI(){
        frame = new JFrame("Manager Board");
        panel = new JPanel();
        textLabel = new JLabel("Welcome");
        viewClientButton = new JButton("View Client");
        dailyReportButton = new JButton("Daily Report");
        logOutButton = new JButton("Log Out");

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Init(panel);
    }

    public void Init(JPanel panel){
        panel.setLayout(null);
        textLabel.setBounds(200,40,200,40);
        viewClientButton.setBounds(200,160,200,40);
        dailyReportButton.setBounds(200,240,200,40);
        logOutButton.setBounds(200,320,200,40);

        panel.add(textLabel);
        panel.add(viewClientButton);
        panel.add(dailyReportButton);
        panel.add(logOutButton);

        viewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                System.out.print(1);
            }
        });

        dailyReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                System.out.print(1);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new WelcomeUI();
            }
        });

    }
}
