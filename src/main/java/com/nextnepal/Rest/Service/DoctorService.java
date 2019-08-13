package com.nextnepal.Rest.Service;

import com.nextnepal.Rest.Model.Doctor;
import com.nextnepal.Rest.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService  extends Doctor{

    @Autowired
    DoctorRepository doctorRepo;


    public List<Doctor> getDoctor() {
        return doctorRepo.findAll();
    }

    public Optional<Doctor> getDoctorById(Long docid) {
        return doctorRepo.findById(docid);
    }

    public Doctor addNewDoctor(Doctor doc) {
        return doctorRepo.save(doc);
    }

    public Doctor updateDoctor(Doctor emp) {
        return doctorRepo.save(emp);
    }

    public void deleteDoctorById(Long docid) {
        doctorRepo.deleteById(docid);
    }

}
