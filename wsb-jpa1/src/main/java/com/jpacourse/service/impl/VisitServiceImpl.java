package com.jpacourse.service.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao vVisitDao) {
        visitDao = vVisitDao;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDao.findOne(id);
        return VisitMapper.mapToTO(entity);
    }

    @Override
    public VisitTO addVisit(VisitTO visitTO) {
        final VisitEntity entity = VisitMapper.mapToEntity(visitTO);
        final VisitEntity newEntity = visitDao.save(entity);
        return VisitMapper.mapToTO(newEntity);
    }

    @Override
    public List<VisitTO> findAllVisitsByPatientId(final Long patientId) {
        final List<VisitEntity> entity = visitDao.findAllPatientsById(patientId);
        return entity.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());

    }
}