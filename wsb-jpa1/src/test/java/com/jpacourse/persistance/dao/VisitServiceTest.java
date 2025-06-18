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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private VisitServiceImpl visitService;

    @Autowired
    private DoctorServiceImpl doctorService;

    @Transactional
    @Test
    public void testShouldFindVisitsByPatientId() {

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

        VisitTO visitTO1 = new VisitTO();
        visitTO1.setDescription("Wizyta kontrolna");
        visitTO1.setTime(LocalDateTime.of(2025, 06, 16, 8, 0, 0));
        visitTO1.setPatient(savedPatient);
        visitTO1.setDoctor(savedDoctor);
        VisitTO savedVisit = visitService.addVisit(visitTO1);
        Long visit_id1 = savedVisit.getId();

        VisitTO visitTO2 = new VisitTO();
        visitTO2.setDescription("Wizyta kontrolna");
        visitTO2.setTime(LocalDateTime.of(2025, 06, 16, 10, 0, 0));
        visitTO2.setPatient(savedPatient);
        visitTO2.setDoctor(savedDoctor);
        VisitTO savedVisit2 = visitService.addVisit(visitTO1);
        Long visit_id2 = savedVisit.getId();

        // when

        VisitTO foundVisit = visitService.findById(visit_id1);

        // then

        assertThat(foundVisit).isNotNull();
        assertThat(visitTO1.getPatient().getId()).isEqualTo(patient_id);

    }
}