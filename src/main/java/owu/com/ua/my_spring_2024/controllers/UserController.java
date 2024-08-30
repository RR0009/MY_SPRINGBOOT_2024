package owu.com.ua.my_spring_2024.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import owu.com.ua.my_spring_2024.dao.UserDao;
import owu.com.ua.my_spring_2024.models.User;
import owu.com.ua.my_spring_2024.services.MailService;
import owu.com.ua.my_spring_2024.services.UserService;

import java.awt.*;
import java.io.File;
import java.util.List;

@RestController
@AllArgsConstructor
@Data
//@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private MailService mailService;


    @SneakyThrows
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public User saveUser (@RequestBody @Valid User user) {
        mailService.sendMailtoUser(user);
       return userService.saveUser(user);


    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));

    }

    @DeleteMapping("/users")
    public ResponseEntity<List<User>> deleteUserById(@RequestParam("id") int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok(userService.getAllUsers());

    }

    @SneakyThrows
    @PostMapping("/users/savewithavatar")

    public void saveWithAvatar(@RequestParam ("avatar") MultipartFile avatar, @RequestParam ("name") String name) {
        User user = new User();
        user.setName(name);
        String originalFilename = avatar.getOriginalFilename();
        user.setAvatar(originalFilename);

        String path = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "qqq" + File.separator + originalFilename;

        File transferDestinationFile = new File(path);
       avatar.transferTo(transferDestinationFile);

       userService.saveUser(user);


        }

        @GetMapping("/users/activate{id}")

    public void activateUser(@PathVariable int id) {
            User user = userService.getUserById(id);
            user.setActivated(true);
            userService.saveUser(user);

        }

        @PostMapping("/users/saveWithEmail")

        public void saveWithEmail(@RequestBody User user) {

        userService.saveUser(user);

        }

    }






