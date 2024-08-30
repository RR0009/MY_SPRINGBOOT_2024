package owu.com.ua.my_spring_2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "name can not be vacant")
    @Size(message = "not less than 3 chars")
    @Size(message = "255 is a maximum size")
    private String name;
    private String avatar;
    private String email;
    private boolean isActivated = false;

//    public User(String name, String avatar) {
//        this.name = name;
//        this.avatar = avatar;
//    }

    public User(String name) {
        this.name = name;
    }
}
