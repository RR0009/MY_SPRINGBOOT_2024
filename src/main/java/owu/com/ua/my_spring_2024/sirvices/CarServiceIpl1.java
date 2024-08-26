package owu.com.ua.my_spring_2024.sirvices;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.dao.CarDao;
import owu.com.ua.my_spring_2024.modules.Car;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceIpl1 implements CarService{

    private CarDao carDao;

    @Override
    public Car saveCar(Car car) {
        if(car.getId() <0){
            throw new IllegalArgumentException("Car id cannot be negative");
        }
        return carDao.save(car);
    }

    @Override
    public List<Car> getAllCars() {

        return carDao.findAll();
    }

    @Override
    public Car getCarById(int id) {
        if(id <0){
            throw new IllegalArgumentException("Car id cannot be negative");
        }
        return carDao.findById(id).get();
    }


    @Override
    public List<Car> deleteCarById(int id) {
        if(id <0){
            throw new IllegalArgumentException("Car id cannot be negative");
        }
        carDao.deleteById(id);
        return carDao.findAll();

    }
}
