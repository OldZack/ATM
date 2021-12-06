import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountUI extends JFrame{
    private JPanel panel;
    private JLabel accountType;
    private JComboBox<String> types;
    private JScrollPane selectType;
    private JLabel currencyType;
    private JComboBox<String> currencyTypes;
    private JScrollPane selectCurrencyType;
    private JButton okButton;
    private JButton backButton;

    public AccountUI()
    {
        panel = new JPanel();
        accountType = new JLabel("Account Type");
        String []at= {"Checking","Saving","Security"};
        types = new JComboBox<String>(at);
        selectType = new JScrollPane(types);

        currencyType = new JLabel("Currency Type");
        String []ct= {"USD","RMB","EUR"};
        currencyTypes = new JComboBox<String>(ct);
        selectCurrencyType = new JScrollPane(currencyTypes);

        okButton = new JButton("OK");
        backButton = new JButton("Back");

        this.add(panel);
        this.setTitle("Create Account Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }


    private void Init(JPanel panel){
        panel.setLayout(null);
        accountType.setBounds(100,60,100,40);
        selectType.setBounds(250,60,200,40);
        currencyType.setBounds(100,160,100,40);
        selectCurrencyType.setBounds(250,160,200,40);
        okButton.setBounds(150,280,100,50);
        backButton.setBounds(350,280,100,50);

        panel.add(accountType);
        panel.add(selectType);
        panel.add(currencyType);
        panel.add(selectCurrencyType);
        panel.add(okButton);
        panel.add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
                System.out.println("Success!");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
            }
        });
    }
}

