import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerUI extends JFrame{
    private JPanel panel;
    private JLabel textLabel;
    private JButton viewClientButton;
    private JButton dailyReportButton;
    private JButton logOutButton;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());
    ATM atm = ATM.getInstance();

    public ManagerUI(){
        panel = new JPanel();
        textLabel = new JLabel("Welcome");
        viewClientButton = new JButton("View Client");
        dailyReportButton = new JButton("Daily Report");
        logOutButton = new JButton("Log Out");
        time = new JLabel();

        this.setTitle("Manager Board");
        this.add(panel);
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    public void Init(JPanel panel){
        panel.setLayout(null);
        time.setText(temp);
        textLabel.setBounds(200,40,200,40);
        viewClientButton.setBounds(200,160,200,40);
        dailyReportButton.setBounds(200,240,200,40);
        logOutButton.setBounds(200,320,200,40);
        time.setBounds(10,10,200,30);
        panel.add(time);
        panel.add(textLabel);
        panel.add(viewClientButton);
        panel.add(dailyReportButton);
        panel.add(logOutButton);

        viewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewClientUI();
            }
        });

        dailyReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new DailyReportUI();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeUI();
            }
        });

    }
}
