package com.example.AppointmentSystem.controller;

import com.example.AppointmentSystem.dto.DoctorRequest;
import com.example.AppointmentSystem.dto.DoctorResponse;
import com.example.AppointmentSystem.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping
    public ResponseEntity<String>addDoctor(@RequestBody DoctorRequest doctorRequest){
        String response=doctorService.addDoctor(doctorRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>>getListOfDoctors(){

        List<String>doctorName=doctorService.getListOfDoctors();
        return new ResponseEntity<>(doctorName,HttpStatus.FOUND);
    }

    @GetMapping("/detail/page")
    public ResponseEntity<List<DoctorResponse>>getDetailOfDoctors(){

        List<DoctorResponse>doctorResponses=doctorService.getDetailOfDoctors();
        return new ResponseEntity<>(doctorResponses,HttpStatus.FOUND);
    }
}
