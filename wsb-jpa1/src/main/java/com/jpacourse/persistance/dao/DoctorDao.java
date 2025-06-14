package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;

import java.time.LocalDateTime;

public interface DoctorDao extends Dao<DoctorEntity, Long> {

    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
}
