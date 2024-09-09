package owu.com.ua.my_spring_2024.security;


import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import owu.com.ua.my_spring_2024.models.Customer;
import owu.com.ua.my_spring_2024.services.CustomerServiceImpl;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private CustomerServiceImpl customerServiceImpl;

    @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }


   @Bean
    public UserDetailsService userDetailsService() {
        System.out.println(" userDetailsService");


        return username -> {
            System.out.println(username);
            Customer customer = customerServiceImpl.getCustomerByUsername(username);
            User user = new User(customer.getUsername(),
                    customer.getPassword(),
                    Arrays.asList(new SimpleGrantedAuthority(customer.getRole()))

            );
                return user;
        };
    }

    @SneakyThrows
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.authorizeRequests(auth ->
                auth
                        .requestMatchers(HttpMethod.GET,"/admin").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/user").hasAnyRole("USER","ADMIN")
                        .anyRequest().permitAll()

                )
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

                return httpSecurity.build();
    }



}
