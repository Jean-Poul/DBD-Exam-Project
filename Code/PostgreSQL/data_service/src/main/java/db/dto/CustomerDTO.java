package db.dto;

public class CustomerDTO {
    private String email;
    private String password;

    public CustomerDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
