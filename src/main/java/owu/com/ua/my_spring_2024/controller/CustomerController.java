package owu.com.ua.my_spring_2024.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import owu.com.ua.my_spring_2024.models.Customer;
import owu.com.ua.my_spring_2024.services.CustomerService;
import owu.com.ua.my_spring_2024.services.CustomerServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerServiceImpl customerServiceImpl;
    private PasswordEncoder passwordEncoder;



    @PostMapping("/save")

    public void saveCustomer(@RequestBody Customer customer) {

        String password = customer.getPassword();
        String encode = passwordEncoder.encode(password);
        customer.setPassword(encode);

        customerServiceImpl.save(customer);


    }

    @GetMapping("/user")
    public List<Customer> getAllCustomers() {
       return customerServiceImpl.getAllCustomers();
    }




}
