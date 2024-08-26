package owu.com.ua.my_spring_2024.sirvices;


import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.dao.CarDao;
import owu.com.ua.my_spring_2024.modules.Car;

import java.util.List;

@Service
public interface CarService {

    Car saveCar(Car car);

    List<Car> getAllCars();

    Car getCarById(int id);

    List<Car> deleteCarById(int id);
}
