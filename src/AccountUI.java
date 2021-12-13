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
    private JLabel principal;
    private JTextField amount;
    private JLabel notice;
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
        String []ct= {"USD","CNY","EUR"};
        currencyTypes = new JComboBox<String>(ct);
        selectCurrencyType = new JScrollPane(currencyTypes);

        principal = new JLabel("Principal: ");
        amount = new JTextField(100);
        notice = new JLabel();

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
        accountType.setBounds(100,40,100,40);
        selectType.setBounds(250,40,200,40);
        currencyType.setBounds(100,110,100,40);
        selectCurrencyType.setBounds(250,110,200,40);
//        String content = "";
//        content += "Since a fee will be charged for creating an account, ";
//        content += System.lineSeparator();
//        content += "the actual principal might be less than the input.";
//        notice.setText(content);

        principal.setBounds(100,180,100,40);
        amount.setBounds(250,180,200,40);
        notice.setBounds(100,250,400,40);
        okButton.setBounds(150,280,100,50);
        backButton.setBounds(350,280,100,50);

        panel.add(accountType);
        panel.add(selectType);
        panel.add(currencyType);
        panel.add(selectCurrencyType);
        panel.add(principal);
        panel.add(amount);
        panel.add(notice);
        panel.add(okButton);
        panel.add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new CustomerUI();
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

