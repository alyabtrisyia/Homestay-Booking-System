package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.model.Room;

import java.util.List;

public interface AdminService {

    Room addRoom(Room room);

    Room updateRoom(Long id, Room room);

    void deleteRoom(Long id);

    List<Room> viewBookedRooms();
}
