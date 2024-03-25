import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener{
//    JTextField usrText;
    public gui(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Free Fall Simulator");

        frame.add(panel, BorderLayout.CENTER);

        panel.setLayout(null);

        //setup text and input box
        JLabel text_height = new JLabel("Initial Height (m):");
        text_height.setBounds(10, 0, 200, 25);
        panel.add(text_height);

        JTextField usrText = new JTextField(20);
        usrText.setBounds(120, 0, 90,25);
        panel.add(usrText);

        JButton startBtn = new JButton("Start");
        startBtn.setBounds(220,0,70, 25);
        panel.add(startBtn);
        startBtn.addActionListener(actionEvent -> {
            calculation usrCalc = new calculation();
            String heightStr = usrText.getText();
            usrCalc.setUsrHeight(Double.parseDouble(heightStr));
            usrCalc.startCalculating();
        });

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
