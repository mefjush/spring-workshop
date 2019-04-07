package com.sda.weather;

import com.sda.weather.utils.Hostname;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AboutController {

    @GetMapping("/about/simple")
    @ResponseBody
    public String about() {
        String author = "Mateusza";
        String hostname = Hostname.getHostname();
        return "Strona napisania przez " + author + ". Uruchomiona na " + hostname + ".";
    }

    @GetMapping("/about")
    public String abt(Model model) {
        model.addAttribute("name", "Mateusza");
        model.addAttribute("host", Hostname.getHostname());
        return "about";
    }
}
