package com.csc3402.security.homestay.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "availability_form")
public class AvailabilityForm {

    @Id
    private Long roomId;
    private Boolean roomAvailableStatus;

    public AvailabilityForm() {
    }
}

