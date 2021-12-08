import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyReportUI extends JFrame {

    private JPanel panel;
    private JButton backButton;
    private JLabel record;
    private JTextArea transRecord;

    public DailyReportUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        record = new JLabel("Daily Transaction Record");
        transRecord = new JTextArea();

        this.add(panel);
        this.setTitle("Daily Report Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){
        panel.setLayout(null);
        String content = "test";
        transRecord.setText(content);
        transRecord.setEditable(false);
        record.setBounds(100,30,200,30);
        transRecord.setBounds(100,80,400,200);
        backButton.setBounds(250,300,100,50);

        panel.add(record);
        panel.add(transRecord);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ManagerUI();
            }
        });
    }
}
