package com.devtoolbox;

import javax.swing.*;
import java.awt.*;

public class JsonFormatter extends JPanel {

    JTextArea input = new JTextArea();
    JTextArea output = new JTextArea();

    JButton formatBtn = new JButton("Format JSON");
    JButton clearBtn = new JButton("Clear");

    public JsonFormatter(){

        setLayout(new BorderLayout());

        input.setLineWrap(true);
        output.setLineWrap(true);

        JPanel textPanel = new JPanel(new GridLayout(2,1));

        textPanel.add(new JScrollPane(input));
        textPanel.add(new JScrollPane(output));

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(formatBtn);
        buttonPanel.add(clearBtn);

        add(textPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        formatBtn.addActionListener(e -> {

            String json = input.getText();

            try {

                json = json.replace("{", "{\n");
                json = json.replace("}", "\n}");
                json = json.replace(",", ",\n");

                output.setText(json);

            } catch (Exception ex) {

                output.setText("Invalid JSON");

            }

        });

        clearBtn.addActionListener(e -> {

            input.setText("");
            output.setText("");

        });
    }
}