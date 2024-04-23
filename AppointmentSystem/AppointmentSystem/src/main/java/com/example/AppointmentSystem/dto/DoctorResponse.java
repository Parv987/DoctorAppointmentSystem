package com.example.AppointmentSystem.dto;

import com.example.AppointmentSystem.Enum.Gender;
import com.example.AppointmentSystem.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponse {

    String name;
    int age;
    String emailId;
    Gender gender;
    Speciality speciality;
    int pricePerAppointment;
    String experience;
}
