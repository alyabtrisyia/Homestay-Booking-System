package com.csc3402.security.homestay.controller;

import com.csc3402.security.homestay.model.Room;
import com.csc3402.security.homestay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room){
        return adminService.addRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        return adminService.updateRoom(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable Long id) {
        adminService.deleteRoom(id);
    }

    @GetMapping("/rooms")
    public List<Room> viewBookedRooms() {
        return adminService.viewBookedRooms();
    }
}


