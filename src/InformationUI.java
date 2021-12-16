import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;

public class InformationUI extends JFrame{

    private JPanel panel;
    private JLabel account;
    private JLabel trans;
    private JTextArea info;
    private JTextArea transaction;
    private JButton backButton;
    private JLabel time;
    private JLabel accountHeader;
    private JLabel transHeader;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String content = df.format(new Date());
    private ArrayList<Transaction> transList;
    ATM atm = ATM.getInstance();

    public InformationUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        trans = new JLabel("Transaction Record");
        account = new JLabel("Account information");
        time = new JLabel();
        info = new JTextArea();
        transaction = new JTextArea();
        transList = new ArrayList<Transaction>();
        accountHeader = new JLabel();
        transHeader = new JLabel();
        account.setForeground(Color.BLUE);
        trans.setForeground(Color.BLUE);

        this.add(panel);
        this.setTitle("Information Board");
        this.setSize(800, 700);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){

        String temp = "";
        Customer cs = (Customer) atm.getCurrUser();
        String cName = cs.getUserName();
        double cSavingBalance,cCheckingBalance,cSecurityBalance;
        double cSavingLoan,cCheckingLoan,cSecurityLoan;
        if(cs.getSavingAccount()!=null) {
            cSavingBalance = cs.getSavingAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cSavingLoan = cs.getSavingAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Saving Account  ";
            temp += "  " + cSavingBalance + "  ";
            temp += "  " + cSavingLoan;
            temp += "\n";
        }
        if(cs.getCheckingAccount()!=null) {
            cCheckingBalance=cs.getCheckingAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cCheckingLoan=cs.getCheckingAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Checking Account  ";
            temp += "  " + cCheckingBalance + "  ";
            temp += "  " + cCheckingLoan;
            temp += "\n";
        }

        if(cs.getSecurityAccount()!=null) {
            cSecurityBalance = cs.getSecurityAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cSecurityLoan = cs.getSecurityAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Security Account  ";
            temp += "  " + cSecurityBalance + "  ";
            temp += "  " + cSecurityLoan;
            temp += "\n";
        }


        if (cs.getCheckingAccount() != null){
            transList.addAll(cs.getCheckingAccount().getTransactions());
        }
        if (cs.getSavingAccount() != null){
            transList.addAll(cs.getSavingAccount().getTransactions());
        }
        if (cs.getSecurityAccount() != null){
            transList.addAll(cs.getSecurityAccount().getTransactions());
        }

        String tr = "";
        if (!transList.isEmpty()){
            for (Transaction t : transList){
                tr += (t.toString()) + "\n";
            }
        }

        panel.setLayout(null);
        info.setEditable(false);
        transaction.setEditable(false);
        time.setText(content);
        info.setText(temp);
        transaction.setText(tr);
        accountHeader.setText("Name  |  Account Type  |  Balance  |  Load");
        transHeader.setText("Name  |  Account Type  |  Transaction Time  |  Currency  |  Original  |  Action  |  Fee  |  Balance");


        backButton.setBounds(350,620,100,50);
        time.setBounds(10,10,200,30);
        account.setBounds(100,30,200,20);
        accountHeader.setBounds(100,70,600,20);
        info.setBounds(100,90,600,100);
        trans.setBounds(100,210,200,20);
        transHeader.setBounds(100,250,600,20);
        transaction.setBounds(100,270,600,330);

        panel.add(accountHeader);
        panel.add(transHeader);
        panel.add(transaction);
        panel.add(account);
        panel.add(trans);
        panel.add(info);
        panel.add(time);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
            }
        });
    }
}
