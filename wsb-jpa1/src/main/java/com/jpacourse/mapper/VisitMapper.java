package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.ArrayList;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {

        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        DoctorTO doctorTO = DoctorMapper.mapToTO(visitEntity.getDoctor());
        visitTO.setDoctor(doctorTO);
        PatientTO patientTO = PatientMapper.mapToTO(visitEntity.getPatient());
        visitTO.setPatient(patientTO);
        if (doctorTO != null) {
            if (doctorTO.getVisits() == null) {
                doctorTO.setVisits(new ArrayList<>());
        }
            doctorTO.getVisits().add(visitTO);
        }
        if (patientTO != null) {
            if (patientTO.getVisits() == null) {
                patientTO.setVisits(new ArrayList<>());
            }
            patientTO.getVisits().add(visitTO);
        }
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if(visitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(visitTO.getDoctor());
        visitEntity.setDoctor(doctorEntity);
        PatientEntity patientEntity = PatientMapper.mapToEntity(visitTO.getPatient());
        visitEntity.setPatient(patientEntity);
        if (doctorEntity != null) {
            doctorEntity.getVisits().add(visitEntity);
        }
        if (patientEntity != null) {
            patientEntity.getVisits().add(visitEntity);
        }
        return visitEntity;
    }
}
