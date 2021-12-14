import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanUI extends JFrame{
    private JPanel panel;
    private JLabel loanInfo;
    private JLabel choice;
    private JButton borrowButton;
    private JButton returnButton;
    private JButton backButton;
    private JTextArea info;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());

    public LoanUI(){
        panel = new JPanel();
        borrowButton = new JButton("Borrow");
        returnButton = new JButton("Return");
        backButton = new JButton("Back");
        info = new JTextArea();
        loanInfo = new JLabel("Current Loan Information");
        choice = new JLabel("Do you want to borrow or return?");
        time = new JLabel();

        this.add(panel);
        this.setTitle("Loan Board");
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

        borrowButton.setBounds(100,310,100,50);
        returnButton.setBounds(250,310,100,50);
        backButton.setBounds(400,310,100,50);
        info.setBounds(100,60,400,200);
        loanInfo.setBounds(100,20,200,30);
        choice.setBounds(100,250,300,50);
        time.setBounds(10,10,200,30);
        panel.add(time);
        panel.add(loanInfo);
        panel.add(choice);
        panel.add(info);
        panel.add(borrowButton);
        panel.add(returnButton);
        panel.add(backButton);


        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BorrowLoanUI();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReturnLoanUI();
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
