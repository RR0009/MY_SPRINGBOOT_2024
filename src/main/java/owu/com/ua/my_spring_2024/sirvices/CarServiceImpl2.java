package owu.com.ua.my_spring_2024.sirvices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.modules.Car;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl2 implements CarService {
    @Override
    public Car saveCar(Car car) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return List.of();
    }

    @Override
    public Car getCarById(int id) {
        return null;
    }

    @Override
    public List<Car> deleteCarById(int id) {
        return List.of();
    }
}
