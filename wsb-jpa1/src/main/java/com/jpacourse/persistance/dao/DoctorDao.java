package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;

public interface DoctorDao extends Dao<DoctorEntity, Long> {

    DoctorEntity findById(Long id);

    PatientEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description);
}
