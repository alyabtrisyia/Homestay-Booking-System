package com.csc3402.security.homestay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        // Directly return the view you want to show for the home page
        return "index"; // Replace with your desired view name
    }

    @ResponseBody
    @GetMapping("/about")
    public String about() {
        return "About Spring Boot Security";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return " Admin Page";
    }

    @GetMapping("/availability.html")
    public String showAvailabilityPage() {
        return "availability"; // This assumes you have an "availability.html" or "availability" template
    }
}
