package com.example.AppointmentSystem.repository;

import com.example.AppointmentSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {


    @Query(value = "select * from doctor",nativeQuery = true)
    public List<Doctor> getList();
}
