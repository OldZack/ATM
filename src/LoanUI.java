import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanUI extends JFrame{
    private JPanel panel;
    private JButton okButton;
    private JButton backButton;

    public LoanUI(){
        panel = new JPanel();
        okButton = new JButton("OK");
        backButton = new JButton("Back");

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
        okButton.setBounds(150,300,100,50);
        backButton.setBounds(350,300,100,50);
        panel.add(okButton);
        panel.add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                dispose();
                System.out.println("Success!");

                /**
                 * Loans and show feedback
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
