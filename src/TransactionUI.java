import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionUI extends JFrame {

    private JPanel panel;
    private JLabel fromType;
    private JComboBox<String> fromTypes;
    private JScrollPane selectFromType;
    private JLabel toType;
    private JComboBox<String> toTypes;
    private JScrollPane selectToType;
    private JLabel amount;
    private JTextField transAmount;
    private JLabel currencyType;
    private JComboBox<String> currencyTypes;
    private JScrollPane selectCurrencyType;
    private JButton okButton;
    private JButton backButton;
    private JLabel time;
    ATM atm = ATM.getInstance();

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());


    public TransactionUI()
    {
        panel = new JPanel();
        fromType = new JLabel("From Account");
        toType = new JLabel("To Account");
        String []act= {"Checking","Saving","Security"};
        fromTypes = new JComboBox<String>(act);
        selectFromType = new JScrollPane(fromTypes);
        toTypes = new JComboBox<String>(act);
        selectToType = new JScrollPane(toTypes);
        amount = new JLabel("Amount");
        transAmount = new JTextField(30);
        okButton = new JButton("OK");
        backButton = new JButton("Back");
        currencyType = new JLabel("Currency Type");
        String []ct= {"USD","CNY","EUR"};
        currencyTypes = new JComboBox<String>(ct);
        selectCurrencyType = new JScrollPane(currencyTypes);
        time = new JLabel();


        this.add(panel);
        this.setTitle("Transaction Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }


    private void Init(JPanel panel){
        panel.setLayout(null);
        time.setText(temp);

        fromType.setBounds(100,40,100,40);
        selectFromType.setBounds(250,40,200,40);
        toType.setBounds(100,100,100,40);
        selectToType.setBounds(250,100,200,40);
        currencyType.setBounds(100,160,100,40);
        selectCurrencyType.setBounds(250,160,200,40);
        amount.setBounds(100,220,100,40);
        transAmount.setBounds(250,220,200,40);
        okButton.setBounds(150,300,100,50);
        backButton.setBounds(350,300,100,50);
        time.setBounds(10,10,200,30);

        panel.add(time);
        panel.add(currencyType);
        panel.add(selectCurrencyType);
        panel.add(fromType);
        panel.add(selectFromType);
        panel.add(toType);
        panel.add(selectToType);
        panel.add(amount);
        panel.add(transAmount);
        panel.add(okButton);
        panel.add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fromTypeTemp = fromTypes.getItemAt(fromTypes.getSelectedIndex());
                String toTypeTemp = toTypes.getItemAt(toTypes.getSelectedIndex());
                double amountTemp = Double.valueOf(transAmount.getText()).doubleValue();
                String currencyTypeTemp = currencyTypes.getItemAt(currencyTypes.getSelectedIndex());

                System.out.println(currencyTypeTemp);
                System.out.println(fromTypeTemp);
                System.out.println(toTypeTemp);
                System.out.println(amountTemp);

                String currId = atm.getCurrUser().getUserName();
                Customer c = Database.getUsers().get(currId);
                System.out.println(c);

                CurrencyType cTemp;
                switch (currencyTypeTemp){
                    case "USD" -> {
                        cTemp = CurrencyType.USD;
                        break;
                    }
                    case "EUR" -> {
                        cTemp = CurrencyType.EUR;
                        break;
                    }
                    default -> {
                        cTemp = CurrencyType.CNY;
                        break;
                    }
                }

                AccountType aTemp;
                switch (toTypeTemp){
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

                switch (fromTypeTemp){
                    case "Saving" -> {
                        c.getSavingAccount().transferTo(aTemp, cTemp, amountTemp);
                        break;
                    }
                    case "Security" -> {
                        c.getSecurityAccount().transferTo(aTemp, cTemp, amountTemp);
                        break;
                    }
                    default -> {
                        c.getCheckingAccount().transferTo(aTemp, cTemp, amountTemp);
                        break;
                    }
                }


                JOptionPane.showMessageDialog(null, "Operation Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new CustomerUI();
                /**
                 * Transfer the money and show feedback
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

    }
}

