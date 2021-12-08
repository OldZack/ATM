import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveUI extends JFrame {
    private JPanel panel;
    private JLabel accountType;
    private JLabel amount;
    private JTextField saveAmount;
    private JComboBox<String> types;
    private JScrollPane selectType;

    private JButton okButton;
    private JButton backButton;

    public SaveUI()
    {
        panel = new JPanel();
        accountType = new JLabel("Account Type");
        amount = new JLabel("Amount");
        String []act= {"Checking","Saving","Security"};
        types = new JComboBox<String>(act);
        selectType = new JScrollPane(types);
        saveAmount = new JTextField(30);
        okButton = new JButton("OK");
        backButton = new JButton("Back");

        this.add(panel);
        this.setTitle("Saving Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){
        panel.setLayout(null);
        accountType.setBounds(100,100,100,40);
        selectType.setBounds(250,100,200,40);
        amount.setBounds(100,200,100,40);
        saveAmount.setBounds(250,200,200,40);
        okButton.setBounds(150,300,100,50);
        backButton.setBounds(350,300,100,50);

        panel.add(accountType);
        panel.add(amount);
        panel.add(selectType);
        panel.add(saveAmount);
        panel.add(okButton);
        panel.add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Operation Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new CustomerUI();

                /**
                 * Saving the money and show feedback
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
