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
public class AppointmentRequest {
    Speciality speciality;

    String patientName;

    Gender patientGender;

    int patientAge;

    String doctorName;
}
