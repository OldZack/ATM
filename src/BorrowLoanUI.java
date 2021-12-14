import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowLoanUI extends JFrame{

    private JPanel panel;
    private JLabel loanInfo;
    private JLabel choice;
    private JButton okButton;
    private JButton backButton;
    private JTextField amount;
    private JTextArea info;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());
    ATM atm = ATM.getInstance();

    public BorrowLoanUI(){
        panel = new JPanel();
        okButton = new JButton("OK");
        backButton = new JButton("Back");
        amount = new JTextField(100);
        loanInfo = new JLabel("Current Loan Information");
        info = new JTextArea();
        choice = new JLabel("How much do you want to borrow?");
        time = new JLabel();

        this.add(panel);
        this.setTitle("Return Loan Board");
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

        okButton.setBounds(150,300,100,50);
        backButton.setBounds(350,300,100,50);
        info.setBounds(100,60,400,150);
        loanInfo.setBounds(100,20,200,30);
        choice.setBounds(100,240,250,50);
        amount.setBounds(400,240,100,50);
        time.setBounds(10,10,200,30);

        panel.add(time);
        panel.add(loanInfo);
        panel.add(choice);
        panel.add(info);
        panel.add(okButton);
        panel.add(amount);
        panel.add(backButton);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Operation Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new CustomerUI();

                /**
                 * return the loan and show feedback
                 */

            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoanUI();
            }
        });
    }

}







