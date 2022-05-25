package db.dto;

import db.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomersDTO {
    List<CustomerDTO> customers = new ArrayList();

    public CustomersDTO(List<Customer> customerEntities) {
        customerEntities.forEach((customer) -> {
            customers.add(new CustomerDTO(customer));
        });
    }

}
