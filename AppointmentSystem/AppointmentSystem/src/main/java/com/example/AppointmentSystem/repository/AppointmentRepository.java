package com.example.AppointmentSystem.repository;

import com.example.AppointmentSystem.Enum.Speciality;
import com.example.AppointmentSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppointmentSystem.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointments,Integer> {
    @Query(value = "select * from appointments",nativeQuery = true)
    List<Appointments> getListOfAppointments();
}
