package com.devtoolbox;

import javax.swing.*;

public class MainApp extends JFrame {

    public MainApp() {

        setTitle("Dev Toolbox");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("JSON Formatter", new JsonFormatter());
        tabs.add("Base64 Tool", new Base64Tool());
        tabs.add("Hash Generator", new HashGenerator());
        tabs.add("Password Generator", new PasswordGenerator());
        tabs.add("URL Encoder", new UrlEncoder());

        add(tabs);

        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {}

        new MainApp();
    }
}