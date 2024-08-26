package owu.com.ua.my_spring_2024.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.my_spring_2024.modules.Car;

public interface CarDao extends JpaRepository<Car,Integer> {


}
