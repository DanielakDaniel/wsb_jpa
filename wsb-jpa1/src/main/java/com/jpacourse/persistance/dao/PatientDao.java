package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    PatientEntity findById(Long id);

    List<PatientEntity> findByLastName(String lastName);

    PatientEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description);

}
