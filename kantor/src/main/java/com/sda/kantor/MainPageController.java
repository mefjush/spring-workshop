package com.sda.kantor;

import com.sda.kantor.utils.Hostname;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainPageController {

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        String author = "Mateusza";
        String hostname = Hostname.getHostname();
        return "Strona napisania przez " + author + ". Uruchomiona na " + hostname + ".";
    }
}
