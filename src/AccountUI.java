import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());
    ATM atm = ATM.getInstance();


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
        time = new JLabel();

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
        time.setText(temp);
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
        time.setBounds(10,10,200,30);
        panel.add(time);
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
                String typeTemp = types.getItemAt(types.getSelectedIndex());
                String currencyTemp = currencyTypes.getItemAt(currencyTypes.getSelectedIndex());
                double amountTemp = Double.valueOf(amount.getText()).doubleValue();
                System.out.println(typeTemp);
                System.out.println(currencyTemp);
                System.out.println(amountTemp);

                Customer currUser = (Customer) atm.getCurrUser();
                CurrencyType cTemp;
                AccountType aTemp;

                switch (typeTemp){
//                    case "Checking" -> {
//                        aTemp = AccountType.CHECKING;
//                        break;
//                    }
                    case "Saving" -> {
                        aTemp = AccountType.SAVING;
                        break;
                    }
                    case "Security" -> {
                        aTemp = AccountType.SECURITY;
                        break;
                    }
                    default -> {
                        aTemp = AccountType.CHECKING;
                        break;
                    }
                }

                switch (currencyTemp){
                    case "USD" -> {
                        cTemp = CurrencyType.USD;
                        break;
                    }
//                    case "CNY" -> {
//                        cTemp = CurrencyType.CNY;
//                        break;
//                    }

                    case "EUR" -> {
                        cTemp = CurrencyType.EUR;
                        break;
                    }
                    default -> {
                        cTemp = CurrencyType.CNY;
                        break;
                    }
                }


                try {
                    currUser.createAccount(aTemp, cTemp, amountTemp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }


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






