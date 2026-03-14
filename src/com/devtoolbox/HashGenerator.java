package com.devtoolbox;

import javax.swing.*;
import java.awt.*;
import java.security.MessageDigest;

public class HashGenerator extends JPanel {

    JTextField input = new JTextField(30);
    JTextArea output = new JTextArea(5,40);

    JButton md5Btn = new JButton("MD5");
    JButton sha256Btn = new JButton("SHA-256");

    public HashGenerator(){

        setLayout(new FlowLayout());

        add(new JLabel("Enter Text"));
        add(input);

        add(md5Btn);
        add(sha256Btn);

        add(new JScrollPane(output));

        md5Btn.addActionListener(e -> generateHash("MD5"));
        sha256Btn.addActionListener(e -> generateHash("SHA-256"));
    }

    private void generateHash(String algorithm){

        try{

            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hash = md.digest(input.getText().getBytes());

            StringBuilder hex = new StringBuilder();

            for(byte b : hash){
                hex.append(String.format("%02x", b));
            }

            output.setText(hex.toString());

        }catch(Exception ex){
            output.setText("Error generating hash");
        }
    }
}