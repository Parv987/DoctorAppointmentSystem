package com.example.AppointmentSystem.controller;


import com.example.AppointmentSystem.dto.AppointmentRequest;
import com.example.AppointmentSystem.dto.AppointmentResponse;
import com.example.AppointmentSystem.dto.DoctorResponse;
import com.example.AppointmentSystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/availability")
    public ResponseEntity<String> availability(@RequestBody AppointmentRequest appointmentRequest){
        String response=appointmentService.checkAvailabilityAndAddAppointment(appointmentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<AppointmentResponse>>getDetailOfAppointments(){

        List<AppointmentResponse>appointmentResponses=appointmentService.getDetailOfAppointments();
        return new ResponseEntity<>(appointmentResponses,HttpStatus.FOUND);
    }
}
