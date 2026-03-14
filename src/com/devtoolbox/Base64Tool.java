package com.devtoolbox;

import javax.swing.*;
import java.awt.*;
import java.util.Base64;

public class Base64Tool extends JPanel {

    JTextArea input = new JTextArea(8,40);
    JTextArea output = new JTextArea(8,40);

    JButton encodeBtn = new JButton("Encode");
    JButton decodeBtn = new JButton("Decode");

    public Base64Tool(){

        setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(2,1));
        center.add(new JScrollPane(input));
        center.add(new JScrollPane(output));

        JPanel buttons = new JPanel();
        buttons.add(encodeBtn);
        buttons.add(decodeBtn);

        add(center,BorderLayout.CENTER);
        add(buttons,BorderLayout.SOUTH);

        encodeBtn.addActionListener(e -> {
            String text = input.getText();
            String encoded = Base64.getEncoder().encodeToString(text.getBytes());
            output.setText(encoded);
        });

        decodeBtn.addActionListener(e -> {
            String text = input.getText();
            String decoded = new String(Base64.getDecoder().decode(text));
            output.setText(decoded);
        });
    }
}