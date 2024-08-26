package owu.com.ua.my_spring_2024.modules;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "this field can not be vacant")
    @Size(min = 3,message = "minimum 3 chars are required")
    @Size(max = 255,message = "Maximum 255 chars are allowed")
    private String model;
    private String producer;
    private int power;


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