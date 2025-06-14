package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;

public interface VisitDao extends Dao<VisitEntity, Long> {

    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
}
