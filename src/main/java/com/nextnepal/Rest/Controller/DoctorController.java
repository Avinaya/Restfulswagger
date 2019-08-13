package com.nextnepal.Rest.Controller;

import com.nextnepal.Rest.Model.Doctor;
import com.nextnepal.Rest.Service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@Api(value = "DoctorsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {

    @Autowired
    DoctorService doctorService;
     Logger log = LoggerFactory.getLogger(this.getClass());

    // to save the attribute of Doctor
    @PostMapping()
    @ApiOperation("Insert doctor into the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = KafkaProperties.Producer.class)})
    public Doctor createEmployee(@RequestBody Doctor newdoc) {
        return doctorService.addNewDoctor(newdoc);
    }

    //To display all the doctor store in the database
    @GetMapping()
    public List<Doctor> getDoctor(){
        return doctorService.getDoctor();
    }

    //To get Doctor by their id
    @GetMapping("/{id}")
    public Doctor getEmployeeById(@PathVariable Long id) throws Exception {
        Optional<Doctor> doc =  doctorService.getDoctorById(id);
        if(!doc.isPresent())
            log.info("Couldn't find Doctor with id");
        return doc.get();
    }

    /*Delete an Doctor*/
    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable long id) throws Exception {
        log.info("Delete Doctor by id is invoked.");

        Optional<Doctor> doc =  doctorService.getDoctorById(id);
        if(!doc.isPresent())
            log.info("Could not find Doctor with id- ");
        doctorService.deleteDoctorById(id);
    }

    /*update doctor*/
    @PutMapping("/{id}")
    public Doctor updateDoctor(@RequestBody Doctor updoc, @PathVariable Long id) throws Exception {
        log.info("Update doctor detail by id is invoked");

        Optional<Doctor> doc =  doctorService.getDoctorById(id);

        if (!doc.isPresent()){
            log.info("Could not find doctor with id-");
        }

        updoc.setDname(doc.get().getDname());
        updoc.setDaddress(doc.get().getDaddress());
        updoc.setDphoneno(doc.get().getDphoneno());
        updoc.setDspeciality(doc.get().getDspeciality());
        updoc.setdUsername(doc.get().getdUsername());
        updoc.setDphoneno(doc.get().getdPassword());

        return doctorService.updateDoctor(updoc);
    }


}
