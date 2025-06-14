package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.service.impl.DoctorServiceImpl;
import com.jpacourse.service.impl.PatientServiceImpl;
import com.jpacourse.service.impl.VisitServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private VisitServiceImpl visitService;

    @Autowired
    private DoctorServiceImpl doctorService;

    @Transactional
    @Test
    public void deletePatient() {

        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Jack");
        patientTO.setLastName("Smith");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("jsmith@gmail.com");
        patientTO.setPatientNumber("JS1");
        patientTO.setDateOfBirth(LocalDate.of(2000, 01, 01));
        PatientTO savedPatient = patientService.addPatient(patientTO);
        Long id = savedPatient.getId();

        // when
        patientService.deletePatient(id);

        // then
        assertThrows(Exception.class, () -> patientService.deletePatient(id));

    }
}
