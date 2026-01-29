package dto;

public class ComplaintDTO {

    private String name;
    private String email;
    private String description;

    // Constructor
    public ComplaintDTO(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    // Default constructor (optional)
    public ComplaintDTO() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optional: for easy printing
    @Override
    public String toString() {
        return "ComplaintDTO [name=" + name + ", email=" + email + ", description=" + description + "]";
    }
}

