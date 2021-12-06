import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    private JButton okButton;
    private JButton backButton;

    public TransactionUI()
    {
        panel = new JPanel();
        fromType = new JLabel("From");
        toType = new JLabel("To");
        String []act= {"Checking","Saving","Security"};
        fromTypes = new JComboBox<String>(act);
        selectFromType = new JScrollPane(fromTypes);
        toTypes = new JComboBox<String>(act);
        selectToType = new JScrollPane(toTypes);
        amount = new JLabel("Amount");
        transAmount = new JTextField(30);
        okButton = new JButton("OK");
        backButton = new JButton("Back");

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
        fromType.setBounds(100,50,100,40);
        selectFromType.setBounds(250,50,200,40);
        toType.setBounds(100,120,100,40);
        selectToType.setBounds(250,120,200,40);
        amount.setBounds(100,200,100,40);
        transAmount.setBounds(250,200,200,40);
        okButton.setBounds(150,280,100,50);
        backButton.setBounds(350,280,100,50);

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
                //dispose();
                System.out.println("Success!");

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
