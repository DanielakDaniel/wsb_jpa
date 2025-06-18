package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @Override
    public VisitEntity findById(Long id) {
        return null;
    }

    @Override
    public List<VisitEntity> findAllPatientsById(Long patientId) {
        return entityManager.createQuery("select v from VisitEntity v where v.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }
}