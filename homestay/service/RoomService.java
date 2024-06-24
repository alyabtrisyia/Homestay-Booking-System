package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.model.Room;
import com.csc3402.security.homestay.model.RoomType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    Iterable<Room> getAllRooms();
    String addARoom(Room r);
    String addRooms(List<Room> rooms);
    Optional<Room> getRoomById(Long id);
    String updateRoomPriceByType(RoomType roomType, Double price, LocalDate checkinDate, LocalDate checkoutDate);
    List<Room> getAvailableRoomsByType(RoomType roomType);
    String deleteRoomById(Long roomId);
}
