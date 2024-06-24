package com.csc3402.security.homestay.repository;

import com.csc3402.security.homestay.model.BookedRoom;
import com.csc3402.security.homestay.model.Role;
import com.csc3402.security.homestay.model.Room;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, Long> {

    List<BookedRoom> findBookedRoomByUserId(Long userId);

    List<BookedRoom> findByRoomAndCheckinDateBetweenOrCheckoutDateBetween(Room room, LocalDate checkinDate, Local checkoutDate, LocalDate checkinDate2, LocalDate checkoutDate2);
}
