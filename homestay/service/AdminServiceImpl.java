package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.model.Room;
import com.csc3402.security.homestay.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room room){
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        existingRoom.setId(room.getId());
        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setRoomPrice(room.getRoomPrice());

        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> viewBookedRooms(){
        return roomRepository.findAll();
    }
}
