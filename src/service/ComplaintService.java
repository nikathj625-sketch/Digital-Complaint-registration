package service;

import java.util.List;
import java.util.Scanner;

import dao.ComplaintDAO;
import daoimpl.ComplaintDAOImpl;
import dto.ComplaintDTO;

public class ComplaintService {

    private ComplaintDAO dao = new ComplaintDAOImpl();
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n==== DIGITAL COMPLAINT REGISTER ====");
            System.out.println("1. Register Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerComplaint();
                    break;

                case 2:
                    viewComplaints();
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    private void registerComplaint() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Complaint Description: ");
        String desc = sc.nextLine();

        ComplaintDTO dto = new ComplaintDTO(name, email, desc);

        if (dao.addComplaint(dto)) {
            System.out.println("Complaint registered successfully!");
        } else {
            System.out.println("Error registering complaint.");
        }
    }

    private void viewComplaints() {
        List<ComplaintDTO> list = dao.getAllComplaints();

        if (list.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        System.out.println("\n--- All Complaints ---");
        for (ComplaintDTO c : list) {
            System.out.println("Name: " + c.getName()
                    + ", Email: " + c.getEmail()
                    + ", Description: " + c.getDescription());
        }
    }
}

