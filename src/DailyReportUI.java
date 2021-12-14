import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyReportUI extends JFrame {

    private JPanel panel;
    private JButton backButton;
    private JLabel record;
    private JTextArea transRecord;
    private JLabel time;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());

    public DailyReportUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        record = new JLabel("Daily Transaction Record");
        transRecord = new JTextArea();
        time = new JLabel();

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
        time.setText(temp);
        transRecord.setText(content);
        transRecord.setEditable(false);
        record.setBounds(100,30,200,30);
        transRecord.setBounds(100,80,400,200);
        backButton.setBounds(250,300,100,50);
        time.setBounds(10,10,200,30);
        panel.add(time);
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
