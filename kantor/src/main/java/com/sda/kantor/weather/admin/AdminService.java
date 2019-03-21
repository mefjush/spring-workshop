package com.sda.kantor.weather.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    //this demonstrates role verification on method level
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminPhoneNumber() {
        return "997";
    }
}
