package com.example.AppointmentSystem.service;

import com.example.AppointmentSystem.dto.DoctorRequest;
import com.example.AppointmentSystem.dto.DoctorResponse;
import com.example.AppointmentSystem.model.Doctor;
import org.springframework.stereotype.Service;
import com.example.AppointmentSystem.repository.DoctorRepository;
import com.example.AppointmentSystem.transformer.DoctorTransformer;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private  final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String addDoctor(DoctorRequest doctorRequest){
        Doctor doctor= DoctorTransformer.doctorRequestToDoctor(doctorRequest);
        doctorRepository.save(doctor);
       return "Doctor saved";
    }

    public List<String> getListOfDoctors() {
        List<Doctor>doctors=doctorRepository.getList();
        List<String>doctorName=new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorName.add(DoctorTransformer.docList(doctor));
        }
        return doctorName;
    }

    public List<DoctorResponse> getDetailOfDoctors() {
        List<Doctor>doctors=doctorRepository.getList();
        List<DoctorResponse>doctorResponses=new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorResponses.add(DoctorTransformer.docDetail(doctor));
        }
        return doctorResponses;


    }
}
