package com.example.AppointmentSystem.dto;

import com.example.AppointmentSystem.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.DayOfWeek;
import java.util.UUID;
import com.example.AppointmentSystem.Enum.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponse {

    String patientName;

    Gender patientGender;

    Speciality speciality;

    int patientAge;

    String doctorName;

    //DoctorResponse doctorResponse;

}
