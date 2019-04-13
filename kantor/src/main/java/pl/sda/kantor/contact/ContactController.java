package pl.sda.kantor.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());

        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();

        String state = (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY))
                ? "zamknięte"
                : "otwarte";

        model.addAttribute("state", state);
        model.addAttribute("date", date);

        return "contact";
    }
}
