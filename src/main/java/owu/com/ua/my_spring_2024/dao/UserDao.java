package owu.com.ua.my_spring_2024.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.my_spring_2024.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
