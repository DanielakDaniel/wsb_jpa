package com.jpacourse.persistance.dao;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given

        PatientEntity patientEntity1 = new PatientEntity();
        patientEntity1.setFirstName("Jan");
        patientEntity1.setLastName("Kowalski");
        patientEntity1.setTelephoneNumber("123456789");
        patientEntity1.setEmail("jan.kowalski@gmail.com");
        patientEntity1.setPatientNumber("P2");
        patientEntity1.setDateOfBirth(LocalDate.of(2001, 01,01));
        patientDao.save(patientEntity1);

        PatientEntity patientEntity2 = new PatientEntity();
        patientEntity2.setFirstName("Paweł");
        patientEntity2.setLastName("Nowak");
        patientEntity2.setTelephoneNumber("987654321");
        patientEntity2.setEmail("pawel.nowak@gmail.com");
        patientEntity2.setPatientNumber("P3");
        patientEntity2.setDateOfBirth(LocalDate.of(2002, 02,02));
        patientDao.save(patientEntity2);


        // when
        List<PatientEntity> entityList = patientDao.findAll();
        List<PatientEntity> entity = patientDao.findByLastName("Kowalski");

        // then
        assertThat(entityList).isNotNull();
        assertThat(entity).isNotNull();
        assertThat(entity.stream().allMatch(p -> "Kowalski".equals(p.getLastName()))).isTrue();
    }

    @Transactional
    @Test
    public void testShouldAddVisitToPatient() {

        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Pac");
        patientEntity.setLastName("Jent");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("pacjent@pacjent.pl");
        patientEntity.setPatientNumber("P1");
        patientEntity.setDateOfBirth(LocalDate.of(2000, 01, 01));
        PatientEntity savedPatient = patientDao.save(patientEntity);
        Long patient_id = savedPatient.getId();

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName("Do");
        doctorEntity.setLastName("Ktor");
        doctorEntity.setTelephoneNumber("987654321");
        doctorEntity.setEmail("doktor@doktor.pl");
        doctorEntity.setDoctorNumber("D1");
        doctorEntity.setSpecialization(Specialization.valueOf("SURGEON"));
        DoctorEntity savedDoctor = doctorDao.save(doctorEntity);
        Long doctor_id = savedDoctor.getId();

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("Wizyta kontrolna");
        visitEntity.setTime(LocalDateTime.of(2025, 06, 16, 8, 0, 0));
        visitEntity.setPatient(savedPatient);
        visitEntity.setDoctor(savedDoctor);
        VisitEntity savedVisit = visitDao.save(visitEntity);
        Long visit_id = savedVisit.getId();

        // when
        PatientEntity patient = patientDao.createVisit(savedPatient.getId(), savedDoctor.getId(), savedVisit.getTime(), savedVisit.getDescription());

        // then
        assertThat(patientEntity.getVisits());
        assertThat(patientEntity.getVisits().isEmpty());

    }

}