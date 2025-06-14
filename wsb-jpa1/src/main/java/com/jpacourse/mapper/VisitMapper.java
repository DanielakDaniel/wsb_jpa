package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {

        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitTO.getId());
        visitTO.setDescription(visitTO.getDescription());
        visitTO.setTime(visitTO.getTime());
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if(visitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitEntity.getId());
        visitEntity.setDescription(visitEntity.getDescription());
        visitEntity.setTime(visitEntity.getTime());
        return visitEntity;
    }
}
