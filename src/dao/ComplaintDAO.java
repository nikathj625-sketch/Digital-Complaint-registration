package dao;

import java.util.List;
import dto.ComplaintDTO;

public interface ComplaintDAO {

    boolean addComplaint(ComplaintDTO complaint);

    List<ComplaintDTO> getAllComplaints();
}
