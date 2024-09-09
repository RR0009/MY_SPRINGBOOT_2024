package owu.com.ua.my_spring_2024.services;


import owu.com.ua.my_spring_2024.models.Customer;

public interface CustomerService {

    void save(Customer customer);

    Customer getCustomerByUsername(String username);


}
