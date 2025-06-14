package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.impl.PatientServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        PatientEntity patientEntity1 = new PatientEntity();

        patientEntity1.setLastName("Kowalski");
        PatientEntity patientEntity2 = new PatientEntity();
        patientEntity2.setLastName("Nowak");
        patientDao.save(patientEntity1);
        patientDao.save(patientEntity2);

        // when
        List<PatientEntity> entity = patientDao.findByLastName("Kowalski");

        // then
        assertThat(patientDao.findAll().size() + 2, patientDao.findAll().size());
        assertThat(patientDao.findByLastName("Kowalski").size() + 2, entity.size());
    }

}
