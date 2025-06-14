package com.jpacourse.service.impl;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.mapper.DoctorMapper;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.service.DoctorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao dDoctorDao) {
        doctorDao = dDoctorDao;
    }

    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity entity = doctorDao.findOne(id);
        return DoctorMapper.mapToTO(entity);
    }

    @Override
    public DoctorTO addDoctor(DoctorTO doctorTO) {
        final DoctorEntity entity = doctorDao.save(DoctorMapper.mapToEntity(doctorTO));
        return DoctorMapper.mapToTO(entity);
    }

}
