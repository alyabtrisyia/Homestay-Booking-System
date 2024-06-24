package com.csc3402.security.homestay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class BookedRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate checkinDate;

    @Column(nullable = false)
    private LocalDate checkoutDate;

    @Column(nullable = false)
    private int adultQty;

    @Column(nullable = false)
    private int childrenQty;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;

    public BookedRoom() {
    }

    @Override
    public String toString() {
        return "BookedRoom{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", adultQty=" + adultQty +
                ", childrenQty=" + childrenQty +'}';
    }
}
