package db.entity;

import java.util.Date;

public class Customer {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private Long address_id;
    private String phone;
    private String firstName;
    private String lastName;
    private Date subscribeDate;

    public Customer() {
    }
}
