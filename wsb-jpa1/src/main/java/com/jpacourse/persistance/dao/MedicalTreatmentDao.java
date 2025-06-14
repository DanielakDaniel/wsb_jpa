package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

import java.time.LocalDateTime;

public interface MedicalTreatmentDao extends Dao <MedicalTreatmentEntity, Long> {
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
}
