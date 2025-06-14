package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    PatientEntity findById(Long id);

    List<PatientEntity> findByLastName(String lastName);

    VisitEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);

}
