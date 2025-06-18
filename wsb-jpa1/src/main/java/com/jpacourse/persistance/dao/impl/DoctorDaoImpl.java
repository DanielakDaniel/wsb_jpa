package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

    @Override
    public DoctorEntity findById(Long id) {
        return null;
    }

    @Override
    public PatientEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {
        return null;
    }
}