import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewClientUI extends JFrame{

    private JPanel panel;
    private JButton backButton;
    private JLabel list;
    private JTextArea clientList;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static String temp = df.format(new Date());
    private JLabel time;
    ATM atm = ATM.getInstance();

    public ViewClientUI(){
        panel = new JPanel();
        backButton = new JButton("Back");
        list = new JLabel("Clients Information");
        clientList = new JTextArea();
        time = new JLabel();

        this.add(panel);
        this.setTitle("Client Info Board");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Init(panel);
    }

    private void Init(JPanel panel){
        panel.setLayout(null);
        clientList.setEditable(false);
        String content = "";
        content += "Index" + " | " + "CustomerID" + " | " + "Balance" + " | " + "Loan";
        content += System.lineSeparator();
        time.setText(temp);

        clientList.setText(content);
        list.setBounds(100,30,200,30);
        clientList.setBounds(100,80,400,200);
        backButton.setBounds(250,300,100,50);
        time.setBounds(10,10,200,30);
        panel.add(time);
        panel.add(list);
        panel.add(clientList);
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





