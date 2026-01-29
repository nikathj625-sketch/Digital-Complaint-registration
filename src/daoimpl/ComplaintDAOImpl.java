package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ComplaintDAO;
import dto.ComplaintDTO;
import util.DBConnection;

public class ComplaintDAOImpl implements ComplaintDAO {

    @Override
    public boolean addComplaint(ComplaintDTO complaint) {
        String sql = "INSERT INTO complaints(name, email, description) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, complaint.getName());
            ps.setString(2, complaint.getEmail());
            ps.setString(3, complaint.getDescription());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ComplaintDTO> getAllComplaints() {
        List<ComplaintDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM complaints";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ComplaintDTO dto = new ComplaintDTO(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("description")
                );
                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
