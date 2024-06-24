package com.csc3402.security.homestay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private Double roomPrice;

    private Boolean roomAvailableStatus;

    public Room() {
    }

    public Room(Long id, RoomType roomType, Double roomPrice, Boolean roomAvailableStatus) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomAvailableStatus = roomAvailableStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Boolean roomAvailableStatus() {
        return roomAvailableStatus;
    }

    public void setRoomAvailableStatus(Boolean roomAvailableStatus) {
        this.roomAvailableStatus = roomAvailableStatus;
    }
}