package com.devtoolbox;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PasswordGenerator extends JPanel {

    JTextField lengthField = new JTextField(5);
    JTextField result = new JTextField(20);

    JButton generateBtn = new JButton("Generate");

    public PasswordGenerator(){

        setLayout(new FlowLayout());

        add(new JLabel("Length:"));
        add(lengthField);
        add(generateBtn);
        add(result);

        generateBtn.addActionListener(e -> generatePassword());
    }

    private void generatePassword(){

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        Random rand = new Random();

        int length = Integer.parseInt(lengthField.getText());

        StringBuilder password = new StringBuilder();

        for(int i=0;i<length;i++){
            password.append(chars.charAt(rand.nextInt(chars.length())));
        }

        result.setText(password.toString());
    }
}