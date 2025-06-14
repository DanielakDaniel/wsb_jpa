package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public PatientEntity findById(Long id) {
        return null;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("select patientEntity from PatientEntity patientEntity where patientEntity.lastName like :lastName", PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    @Override
    public VisitEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        return null;
    }


}
