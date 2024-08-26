package owu.com.ua.my_spring_2024.exception_handlers;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyException {

        @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> ExceptionHandler(MethodArgumentNotValidException e){
            String message = e.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(message,HttpStatusCode.valueOf(400));
        }
}
