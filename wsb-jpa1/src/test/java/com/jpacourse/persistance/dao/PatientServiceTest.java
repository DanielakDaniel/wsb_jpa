package com.jpacourse.persistance.dao;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.enums.Specialization;
import com.jpacourse.service.impl.DoctorServiceImpl;
import com.jpacourse.service.impl.PatientServiceImpl;
import com.jpacourse.service.impl.VisitServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    public void testShouldDeletePatient() {

        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Pac");
        patientTO.setLastName("Jent");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("pacjent@pacjent.pl");
        patientTO.setPatientNumber("P1");
        patientTO.setDateOfBirth(LocalDate.of(2000, 01, 01));
        PatientTO savedPatient = patientService.addPatient(patientTO);
        Long patient_id = savedPatient.getId();

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setFirstName("Do");
        doctorTO.setLastName("Ktor");
        doctorTO.setTelephoneNumber("987654321");
        doctorTO.setEmail("doktor@doktor.pl");
        doctorTO.setDoctorNumber("D1");
        doctorTO.setSpecialization(Specialization.valueOf("SURGEON"));
        DoctorTO savedDoctor = doctorService.addDoctor(doctorTO);

        VisitTO visitTO = new VisitTO();
        visitTO.setDescription("Wizyta kontrolna");
        visitTO.setTime(LocalDateTime.of(2025, 06, 16, 8, 0, 0));
        visitTO.setPatients(List.of(patientTO));
        visitTO.setDoctors(List.of(doctorTO));
        VisitTO savedVisit = visitService.addVisit(visitTO);

        // when
        patientService.deletePatient(patient_id);

        // then
        assertThat(savedPatient).isNull();
        assertThat(savedVisit).isNull();
        assertThat(savedDoctor).isNotNull();

    }

}
