package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.MedicalTreatmentDao;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MedicalTreatmentDaoImpl extends AbstractDao<MedicalTreatmentEntity, Long> implements MedicalTreatmentDao {

    @Override
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {

    }
}