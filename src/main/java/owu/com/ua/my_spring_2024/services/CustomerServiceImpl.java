package owu.com.ua.my_spring_2024.services;


import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.dao.CustomerDao;
import owu.com.ua.my_spring_2024.models.Customer;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        if(customer == null){
            throw new IllegalArgumentException("Customer cannot be null");
        }

        customerDao.save(customer);

    }

    @Override
    public Customer getCustomerByUsername(String username) {
        if(username == null){
            throw new RuntimeException("Username strictly needed!");
        }
        return customerDao.findByUsername(username);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }
}
