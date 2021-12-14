import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockUI extends JFrame{

    private JPanel panel;
    private JButton backButton;
    private JButton okButton;
    private JButton searchButton;
    private JLabel companyLabel;
    private JTextField companyField;
    private JTextArea info;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());
    ATM atm = ATM.getInstance();

    public StockUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        okButton = new JButton("OK");
        searchButton = new JButton("Search");
        time = new JLabel();
        companyField = new JTextField(70);
        companyLabel = new JLabel("Company Name: ");
        info = new JTextArea();

        this.add(panel);
        this.setTitle("Stock Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){
        panel.setLayout(null);

        info.setEditable(false);
        info.setText("test");
        time.setText(temp);

        companyLabel.setBounds(75,20,100,35);
        companyField.setBounds(175,20,200,35);
        okButton.setBounds(150,300,100,50);
        backButton.setBounds(350,300,100,50);
        searchButton.setBounds(400, 20, 75, 30);
        info.setBounds(100,60,400,200);
        time.setBounds(10,10,200,30);
        panel.add(time);
        panel.add(companyLabel);
        panel.add(companyField);
        panel.add(backButton);
        panel.add(okButton);
        panel.add(searchButton);
        panel.add(info);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
                /**
                 * Do the stock and show feedback
                 */
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
            }
        });


    }

}


