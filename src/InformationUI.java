import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InformationUI extends JFrame{

    private JPanel panel;
    private JLabel account;
    private JLabel trans;
    private JTextArea info;
    private JTextArea transaction;
    private JButton backButton;
    private JLabel time;
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

        this.add(panel);
        this.setTitle("Information Board");
        this.setSize(800, 600);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){


        String temp = "";
//        for (Map.Entry<String,Customer> entry : Database.getUsers().entrySet()) {
//            //Customer object
//
//            Customer cs = entry.getValue();
//
//            //Name
//            String cName = cs.getUserName();

            //Deposit and loan

        Customer cs = (Customer) atm.getCurrUser();
        String cName = cs.getUserName();
        double cSavingBalance,cCheckingBalance,cSecurityBalance;
        double cSavingLoan,cCheckingLoan,cSecurityLoan;
        if(cs.getSavingAccount()!=null) {
            cSavingBalance = cs.getSavingAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cSavingLoan = cs.getSavingAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Saving  ";
            temp += "  " + cSavingBalance + "  ";
            temp += "  " + cSavingLoan;
            temp += "\n";
        }
        if(cs.getCheckingAccount()!=null) {
            cCheckingBalance=cs.getCheckingAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cCheckingLoan=cs.getCheckingAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Checking  ";
            temp += "  " + cCheckingBalance + "  ";
            temp += "  " + cCheckingLoan;
            temp += "\n";
        }

        if(cs.getSecurityAccount()!=null) {
            cSecurityBalance = cs.getSecurityAccount().getCurrenciesDeposit().get(CurrencyType.USD).getAmount();
            cSecurityLoan = cs.getSecurityAccount().getLoans().get(CurrencyType.USD).getAmount();
            temp += cName;
            temp += "  Security  ";
            temp += "  " + cSecurityBalance + "  ";
            temp += "  " + cSecurityLoan;
            temp += "\n";
        }

        Customer c = (Customer) atm.getCurrUser();
        transList.addAll(c.getCheckingAccount().getTransactions());
        transList.addAll(c.getSavingAccount().getTransactions());
        transList.addAll(c.getSecurityAccount().getTransactions());

        String tr = "";
        for (Transaction t : transList){
            tr += (t.toString()) + "\n";
        }

        panel.setLayout(null);
        info.setEditable(false);
        transaction.setEditable(false);
        time.setText(content);
        info.setText(temp);
        transaction.setText(tr);

        backButton.setBounds(250,300,100,50);
        time.setBounds(10,10,200,30);
        account.setBounds(100,30,200,30);
        info.setBounds(100,80,600,150);
        trans.setBounds(100,270,200,30);
        transaction.setBounds(100,300,600,150);

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
