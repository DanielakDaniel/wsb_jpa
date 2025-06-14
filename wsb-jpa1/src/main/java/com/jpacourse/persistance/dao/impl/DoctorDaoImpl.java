package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

    @Override
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {

    }
}