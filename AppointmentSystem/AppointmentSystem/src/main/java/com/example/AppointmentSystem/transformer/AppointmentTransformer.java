package com.example.AppointmentSystem.transformer;

import com.example.AppointmentSystem.dto.AppointmentRequest;
import com.example.AppointmentSystem.dto.AppointmentResponse;
import com.example.AppointmentSystem.model.Appointments;

public class AppointmentTransformer {

    public static Appointments AppointmentRequestToAppointment(AppointmentRequest appointmentRequest) {
        return Appointments.builder()
                //.id(appointmentRequest.hashCode())
                .patientName(appointmentRequest.getPatientName())
                .patientAge(appointmentRequest.getPatientAge())
                .patientGender(appointmentRequest.getPatientGender())
                .doctorName(appointmentRequest.getDoctorName())
                .speciality(appointmentRequest.getSpeciality())
                .build();
    }

    public static AppointmentResponse appointmentDetails(Appointments appointment) {
        return AppointmentResponse.builder()
                .patientName(appointment.getPatientName())
                .patientGender(appointment.getPatientGender())
                .patientAge(appointment.getPatientAge())
                .doctorName(appointment.getDoctorName())
                .speciality(appointment.getSpeciality())
                .build();
    }
}
