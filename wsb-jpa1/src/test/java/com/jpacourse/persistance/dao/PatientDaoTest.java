package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.impl.PatientServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        /*
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
        */

        // when
        List<PatientEntity> entityList = patientDao.findAll();
        List<PatientEntity> entity = patientDao.findByLastName("Di");

        // then
        assertThat(entityList).isNotNull();
        assertThat(entity).isNotNull();
        assertThat(entity.stream().allMatch(p -> "Di".equals(p.getLastName()))).isTrue();
    }
    /*
    @Transactional
    @Test
    public void testShouldAddVisitToPatient() {

    }
    */
}