package com.devtoolbox;

import javax.swing.*;
import java.awt.*;

public class JsonFormatter extends JPanel {

    JTextArea input = new JTextArea(10,40);
    JTextArea output = new JTextArea(10,40);
    JButton formatBtn = new JButton("Format JSON");

    public JsonFormatter(){

        setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(2,1));
        center.add(new JScrollPane(input));
        center.add(new JScrollPane(output));

        add(center,BorderLayout.CENTER);
        add(formatBtn,BorderLayout.SOUTH);

        formatBtn.addActionListener(e -> {
            String json = input.getText();
            output.setText(json); // later formatting logic add karenge
        });
    }
}