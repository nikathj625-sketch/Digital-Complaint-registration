package main;

import service.ComplaintService;

public class ComplaintMain {
    public static void main(String[] args) {
        ComplaintService service = new ComplaintService();
        service.showMenu();
    }
}
