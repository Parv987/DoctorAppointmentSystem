package com.example.AppointmentSystem.transformer;

import com.example.AppointmentSystem.dto.DoctorRequest;
import com.example.AppointmentSystem.dto.DoctorResponse;
import com.example.AppointmentSystem.model.Doctor;

public class DoctorTransformer {
    public static Doctor doctorRequestToDoctor(DoctorRequest doctorRequest) {

        return Doctor.builder()
                .name(doctorRequest.getName())
                .emailId(doctorRequest.getEmailId())
                .gender(doctorRequest.getGender())
                .speciality(doctorRequest.getSpeciality())
                .age(doctorRequest.getAge())
                .pricePerAppointment(doctorRequest.getPricePerAppointment())
                .experience(doctorRequest.getExperience())
                .build();
    }
    public static String docList(Doctor doctor){
        return doctor.getName();

    }

    public static DoctorResponse docDetail(Doctor doctor) {
        return DoctorResponse.builder()
                .name(doctor.getName())
                .gender(doctor.getGender())
                .age(doctor.getAge())
                .experience(doctor.getExperience().toString())
                .speciality(doctor.getSpeciality())
                .pricePerAppointment(doctor.getPricePerAppointment())
                .emailId(doctor.getEmailId())
                .build();
    }
}
