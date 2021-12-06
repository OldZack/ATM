import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame{
    private JPanel panel;
    private JLabel textLabel;
    private JButton createAccountButton;
    private JButton saveButton;
    private JButton withdrawButton;
    private JButton transactionButton;
    private JButton informationButton;
    private JButton loanButton;
    private JButton stockButton;
    private JButton logOutButton;

    public CustomerUI(){

        panel = new JPanel();
        textLabel = new JLabel("Welcome");
        createAccountButton = new JButton("Create Account");
        saveButton = new JButton("Save");
        withdrawButton = new JButton("Withdraw");
        transactionButton = new JButton("Transaction");
        informationButton = new JButton("Information");
        loanButton = new JButton("Loan");
        stockButton = new JButton("Stock");
        logOutButton = new JButton("Log Out");

        this.setTitle("Customer Board");
        this.add(panel);
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    public void Init(JPanel panel){
        panel.setLayout(null);
        textLabel.setBounds(300,175,100,50);
        createAccountButton.setBounds(0,40,150,50);
        saveButton.setBounds(0,130,150,50);
        withdrawButton.setBounds(0,220,150,50);
        transactionButton.setBounds(0,310,150,50);

        informationButton.setBounds(450,40,150,50);
        loanButton.setBounds(450,130,150,50);
        stockButton.setBounds(450,220,150,50);
        logOutButton.setBounds(450,310,150,50);

        panel.add(textLabel);
        panel.add(createAccountButton);
        panel.add(saveButton);
        panel.add(withdrawButton);
        panel.add(transactionButton);
        panel.add(informationButton);
        panel.add(loanButton);
        panel.add(stockButton);
        panel.add(logOutButton);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AccountUI();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SaveUI();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WithDrawUI();
            }
        });

        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TransactionUI();
            }
        });
        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InformationUI();
            }
        });
        loanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                System.out.print(1);
                dispose();
                new LoanUI();
            }
        });
        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StockUI();
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
