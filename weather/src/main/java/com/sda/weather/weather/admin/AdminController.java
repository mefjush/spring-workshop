package com.sda.weather.weather.admin;

import com.sda.weather.weather.SmartWeatherCheckRepository;
import com.sda.weather.weather.WeatherCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    private final SmartWeatherCheckRepository smartWeatherCheckRepository;
    private final AdminService adminService;

    public AdminController(SmartWeatherCheckRepository smartWeatherCheckRepository, AdminService adminService) {
        this.smartWeatherCheckRepository = smartWeatherCheckRepository;
        this.adminService = adminService;
    }

    @GetMapping("/admin/weather/stats")
    @ResponseBody
    public String getStats() {
        StringBuilder result = new StringBuilder();

        //all
        result.append("All checks <br/>");
        Iterable<WeatherCheck> all = smartWeatherCheckRepository.findAll();
        all.forEach(check -> result.append(check).append("<br/>"));

        //all for Warsaw
        result.append("Warsaw checks <br/>");
        List<WeatherCheck> warsawChecks = smartWeatherCheckRepository.findByLocation("Warsaw");
        warsawChecks.forEach(check -> result.append(check.getScale()).append("<br/>"));

        //all checks for Fahrenheit
        result.append("Fahrenheit checks <br/>");
        List<WeatherCheck> fChecks = smartWeatherCheckRepository.findByScaleIgnoreCaseOrderByLocationAsc("f");
        fChecks.forEach(check -> result.append(check.getLocation()).append("<br/>"));

        //count all the checks for Wroclaw
        result.append("Wroclaw checks: ")
                .append(smartWeatherCheckRepository.countWeatherCheckByLocation("Wroclaw"))
                .append("<br/>");

        result.append("Locations with at least 5 checks: ")
                .append(smartWeatherCheckRepository.locationsWithAtLeastChecks(5))
                .append("<br/>");

        return result.toString();
    }

    @GetMapping("/admin/contact")
    @ResponseBody
    public String contact() {
        return "Phone number:" + adminService.getAdminPhoneNumber();
    }
}
