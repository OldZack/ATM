import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InformationUI extends JFrame{

    private JPanel panel;
    private JButton backButton;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());

    public InformationUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        time = new JLabel();

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
        time.setText(temp);
        backButton.setBounds(250,300,100,50);
        time.setBounds(10,10,200,30);
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
