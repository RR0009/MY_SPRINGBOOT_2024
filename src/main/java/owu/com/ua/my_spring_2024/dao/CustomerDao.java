package owu.com.ua.my_spring_2024.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.my_spring_2024.models.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

     Customer findByUsername(String username);
}
