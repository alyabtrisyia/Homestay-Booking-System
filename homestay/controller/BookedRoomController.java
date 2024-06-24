package com.csc3402.security.homestay.controller;

import com.csc3402.security.homestay.model.BookedRoom;
import com.csc3402.security.homestay.service.BookedRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookedRoomController {

    @Autowired
    private BookedRoomServiceImpl bookedRoomServiceImpl;

   /* @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("bookedRoom", new BookedRoom());
        return "index"; // This will look for index.html in the templates directory
    } */

    @PostMapping("/bookRoom")
    public String bookRoom(@ModelAttribute BookedRoom bookedRoom){
        bookedRoomServiceImpl.saveBookedRoom(bookedRoom);
        return "redirect:/login";
    }
}
