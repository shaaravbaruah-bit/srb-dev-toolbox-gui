 package com.devtoolbox;

import javax.swing.*;
import java.awt.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class UrlEncoder extends JPanel {

    JTextArea input = new JTextArea(6,40);
    JTextArea output = new JTextArea(6,40);

    JButton encode = new JButton("Encode");
    JButton decode = new JButton("Decode");

    public UrlEncoder(){

        setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(2,1));
        center.add(new JScrollPane(input));
        center.add(new JScrollPane(output));

        JPanel buttons = new JPanel();
        buttons.add(encode);
        buttons.add(decode);

        add(center,BorderLayout.CENTER);
        add(buttons,BorderLayout.SOUTH);

        encode.addActionListener(e -> {
            try{
                output.setText(URLEncoder.encode(input.getText(),"UTF-8"));
            }catch(Exception ex){}
        });

        decode.addActionListener(e -> {
            try{
                output.setText(URLDecoder.decode(input.getText(),"UTF-8"));
            }catch(Exception ex){}
        });
    }
}