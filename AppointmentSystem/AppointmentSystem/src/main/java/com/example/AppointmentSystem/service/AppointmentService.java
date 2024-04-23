package com.example.AppointmentSystem.service;

import com.example.AppointmentSystem.dto.AppointmentRequest;
import com.example.AppointmentSystem.dto.AppointmentResponse;
import com.example.AppointmentSystem.model.Appointments;
import com.example.AppointmentSystem.model.Doctor;
import com.example.AppointmentSystem.repository.AppointmentRepository;
import com.example.AppointmentSystem.transformer.AppointmentTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

//    public AppointmentService(AppointmentRepository appointmentRepository) {
//        this.appointmentRepository = appointmentRepository;
//    }

    public String checkAvailabilityAndAddAppointment(AppointmentRequest appointmentRequest) {

        Doctor doctor =new Doctor();
        if(doctor.getCheckup().size() == 50) {

            return "For this saturday doctors are fully booked sorry for the inconvenience try booking next saturday" +
                    "Eat Healthy ";
        }
        AppointmentResponse appointmentResponse=new AppointmentResponse();
        String doctorNameUserTryingToBook = appointmentResponse.getDoctorName();
        int n=Collections.frequency(doctor.getCheckup(),doctorNameUserTryingToBook);
        if(n>=5){
            return "Doctors of your choice are fully booked next time try to book early till then eat healthy";
        }

        Appointments appointments= AppointmentTransformer.AppointmentRequestToAppointment(appointmentRequest);
        doctor.getCheckup().add(appointments);
            appointmentRepository.save(appointments);
            return "Appointment booked please come prior to 5:45 pm, from 6 pm onwards meetup with doctor starts and if in any case you are late" +
                "then you have wait till the last appointment finishes";

    }

    public List<AppointmentResponse> getDetailOfAppointments() {
        List<Appointments>appointments=appointmentRepository.getListOfAppointments();
        List<AppointmentResponse>appointmentResponses=new ArrayList<>();
        for(Appointments appointment: appointments){
            appointmentResponses.add(AppointmentTransformer.appointmentDetails(appointment));
        }
        return appointmentResponses;
    }
}
