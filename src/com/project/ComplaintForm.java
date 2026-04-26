package com.project;

import javax.swing.*;
import java.sql.*;

public class ComplaintForm extends JFrame {

    JTextField name, email;
    JTextArea complaint;

    ComplaintForm() {
        setTitle("Register Complaint");
        setSize(400, 400);
        setLayout(null);

        JLabel n = new JLabel("Name");
        n.setBounds(30, 30, 100, 25);
        add(n);

        name = new JTextField();
        name.setBounds(150, 30, 150, 25);
        add(name);

        JLabel e = new JLabel("Email");
        e.setBounds(30, 70, 100, 25);
        add(e);

        email = new JTextField();
        email.setBounds(150, 70, 150, 25);
        add(email);

        JLabel c = new JLabel("Complaint");
        c.setBounds(30, 110, 100, 25);
        add(c);

        complaint = new JTextArea();
        complaint.setBounds(150, 110, 150, 100);
        add(complaint);

        JButton submit = new JButton("Submit");
        submit.setBounds(120, 250, 100, 30);
        add(submit);

        submit.addActionListener(e1 -> save());

        setVisible(true);
    }

    void save() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO complaints(name,email,complaint,status) VALUES(?,?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, email.getText());
            ps.setString(3, complaint.getText());
            ps.setString(4, "Pending");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Complaint Registered");
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}