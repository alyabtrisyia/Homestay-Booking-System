package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.model.BookedRoom;
import com.csc3402.security.homestay.repository.BookedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookedRoomServiceImpl implements BookedRoomService {

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @Override
    public void saveBookedRoom(BookedRoom bookedRoom){
        bookedRoomRepository.save(bookedRoom);
    }
}
