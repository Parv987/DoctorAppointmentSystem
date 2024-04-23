package com.example.AppointmentSystem.model;

import com.example.AppointmentSystem.Enum.Experience;
import com.example.AppointmentSystem.Enum.Gender;
import com.example.AppointmentSystem.Enum.Speciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "doctor")
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @Enumerated(EnumType.STRING)
    Experience experience;

    int pricePerAppointment;


    @OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
    List<Appointments> checkup=new ArrayList<>(50);


    //Assuming that a doctor sits from 4pm to 8pm on weekday(Saturday)
    //and 1 doctor can consult 10 patient in a period of 4 hours
}
