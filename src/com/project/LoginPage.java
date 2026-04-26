package com.project;

import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame {

    JTextField username;
    JPasswordField password;

    LoginPage() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel u = new JLabel("Username");
        u.setBounds(30, 30, 80, 25);
        add(u);

        username = new JTextField();
        username.setBounds(120, 30, 120, 25);
        add(username);

        JLabel p = new JLabel("Password");
        p.setBounds(30, 70, 80, 25);
        add(p);

        password = new JPasswordField();
        password.setBounds(120, 70, 120, 25);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(100, 110, 80, 25);
        add(login);

        login.addActionListener(e -> authenticate());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void authenticate() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, username.getText());
            ps.setString(2, new String(password.getPassword()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}