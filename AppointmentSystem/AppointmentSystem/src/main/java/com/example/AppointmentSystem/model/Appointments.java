package com.example.AppointmentSystem.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.example.AppointmentSystem.Enum.*;
import com.example.AppointmentSystem.model.Doctor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    String patientName;

    @Enumerated(EnumType.STRING)
    Gender patientGender;

    int patientAge;

    String doctorName;

    //LocalDate appointmentDate;

    //static final DayOfWeek = day;
    //Saturday;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Doctor doctor;


}
