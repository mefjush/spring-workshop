package pl.sda.kantor.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/user/register")
    public String userRegistration() {
        return "userRegistration";
    }

    @PostMapping("/user/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest httpServletRequest) throws ServletException {

        //TODO co się stanie gdy ktoś zarejestruje istniejącą nazwę użytkownika? Napraw błąd.
        //TODO czy zalogowany użytkownik powinien mieć tu dostęp? Wprowadź poprawkę.

        String encodedPassword = passwordEncoder.encode(password);
        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)", username, encodedPassword, 1);
        jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, ?)", username, "ROLE_USER");

        httpServletRequest.login(username, password);

        return "redirect:/contact";
    }
}
