package owu.com.ua.my_spring_2024.services;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.models.User;

@Service
@AllArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    public void sendMailtoUser(User user) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText("<h1>hello user " + user.getName() + " </h1> " + "  to activate your account click <a href = 'http://localhost8080/" + user.getId() + "'>here</a>",true);

        javaMailSender.send(mimeMessage);
    }





}
