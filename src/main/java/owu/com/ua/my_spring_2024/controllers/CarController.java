package owu.com.ua.my_spring_2024.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.my_spring_2024.modules.Car;
import owu.com.ua.my_spring_2024.sirvices.CarService;
import owu.com.ua.my_spring_2024.sirvices.CarServiceImpl2;
import owu.com.ua.my_spring_2024.sirvices.CarServiceIpl1;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarServiceIpl1 carServiceIpl1;
//    private CarServiceImpl2 carServiceImpl2;
    //    private CarService carService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cars")
    public Car saveCar(@RequestBody @Valid Car car) {

               return carServiceIpl1.saveCar(car);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {

        return carServiceIpl1.getAllCars();
    }


    @GetMapping("cars/{id}")

    public Car getCarById(@PathVariable int id) {

        return carServiceIpl1.getCarById(id);

    }

    @DeleteMapping("/cars")

    public  List<Car> deleteCarById(@RequestParam int id) {
                return carServiceIpl1.deleteCarById(id);
    }
}

//Створити модель
//Car
//        id
//model
//        producer
//power
//
//реалізувати запити
//get /cars
//get /cars/{id}
//post /cars
//delete /cars/{id}
//get cars/power/{value} (знайти всі по потужності) ()
//get cars/producer/{value} (знайти всі по виробнику)
//
//
//Зробити валідацію полів всіх полів і відповідні оробники
//Переробити всі методи контролера, щоб повертати response entity з відповідними статусами
//
//винести логіку в сервісний рівень
//
//Зробити 3 рівня відображення
//Level1 - id model producer power (для endpoint /cars/{id})
//Level2 - model producer power ( для endpoint /cars/power, /cars/producer)
//Level2 - model producer (для endpoint /cars)