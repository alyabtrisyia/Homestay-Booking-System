package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.model.Room;
import com.csc3402.security.homestay.model.RoomType;
import com.csc3402.security.homestay.repository.BookedRoomRepository;
import com.csc3402.security.homestay.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
 
    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String addARoom(Room r) {
        roomRepository.save(r);
        return "Room added";
    }

    public String addRooms(List<Room> rooms) {

        roomRepository.saveAll(rooms);
        return "Rooms added";
    }

    public Optional<Room> getRoomById(Long id) {

        return roomRepository.findById(id);
    }

    @Override
    public String updateRoomPriceByType(RoomType roomType, Double price, LocalDate checkinDate, LocalDate checkoutDate) {
        Optional<Room> optionalRoom = roomRepository.findByRoomType(roomType);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            price = 0.0; // Initialize price variable

            // Determine price based on room type
            switch (room.getRoomType()) {
                case DELUXE_SUITE:
                    price = 150.0;
                    break;
                case FAMILY_SUITE:
                    price = 300.0;
                    break;
                case LUXURY_PENTHOUSE:
                    price = 450.0;
                    break;
                default:
                    // Handle unknown room types if necessary
                    return "Invalid room type.";
            }

            // Calculate number of nights between checkinDate and checkoutDate
            long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);

            // Calculate total price based on price per night and number of nights
            Double totalPrice = price * numberOfNights;

            // Update the room price
            room.setRoomPrice(totalPrice);
            roomRepository.save(room);

            return "Room price updated successfully.";
        } else {
            return "Room not found.";
        }
    }

    public List<Room> getAvailableRoomsByType(RoomType roomType) {
        return roomRepository.findByRoomTypeAndRoomAvailableStatus(roomType,false);
    }

    public String deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
        return "Room deleted";
    }
}
