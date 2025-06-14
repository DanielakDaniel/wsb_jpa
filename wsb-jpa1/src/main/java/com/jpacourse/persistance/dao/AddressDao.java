package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;

public interface AddressDao extends Dao<AddressEntity, Long>
{

    VisitEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
}
