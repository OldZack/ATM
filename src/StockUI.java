import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockUI extends JFrame{

    private JPanel panel;
    private JButton backButton;
    private JButton okButton;

    public StockUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        okButton = new JButton("OK");

        this.add(panel);
        this.setTitle("Information Board");
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
        panel.add(backButton);
        panel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CustomerUI();
                /**
                 * Do the stock and show feedback
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
