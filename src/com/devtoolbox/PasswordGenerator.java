package com.devtoolbox;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PasswordGenerator extends JPanel {

    JTextField lengthField = new JTextField(5);
    JTextField result = new JTextField(20);

    JButton generateBtn = new JButton("Generate");

    public PasswordGenerator(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Length:"), gbc);

        gbc.gridx = 1;
        add(lengthField, gbc);

        gbc.gridx = 2;
        add(generateBtn, gbc);

        gbc.gridx = 3;
        add(result, gbc);

        generateBtn.addActionListener(e -> generatePassword());
    }

    private void generatePassword(){

        try{

            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
            Random rand = new Random();

            int length = Integer.parseInt(lengthField.getText());

            StringBuilder password = new StringBuilder();

            for(int i=0;i<length;i++){
                password.append(chars.charAt(rand.nextInt(chars.length())));
            }

            result.setText(password.toString());

        }catch(Exception e){

            result.setText("Invalid length");

        }
    }
}