package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public List<PatientTO> findByLastName(String lastName) {
        final List<PatientEntity> entities = patientDao.findAll();
        return entities.stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public PatientTO addPatient(PatientTO patientTO) {
        final PatientEntity entity = patientDao.save(PatientMapper.mapToEntity(patientTO));
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void deletePatient(Long patient_id) {
        patientDao.delete(patient_id);
    }

}
