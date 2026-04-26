package com.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewComplaints extends JFrame {

    JTable table;

    ViewComplaints() {
        setTitle("View Complaints");
        setSize(500, 400);

        table = new JTable();
        add(new JScrollPane(table));

        load();

        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM complaints");

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(
                new String[]{"ID", "Name", "Email", "Complaint", "Status"}
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("complaint"),
                    rs.getString("status")
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}