package com.csc3402.security.homestay.repository;

import com.csc3402.security.homestay.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {

    Optional<Room> findByRoomType(RoomType roomType);
    List<Room> findByRoomTypeAndRoomAvailableStatus(RoomType roomType, boolean b);

    List<Room> findAll();
}
