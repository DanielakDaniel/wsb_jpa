package com.jpacourse.service;

import com.jpacourse.dto.VisitTO;

import java.util.List;

public interface VisitService {

    VisitTO findById(final Long id);

    VisitTO addVisit(VisitTO visitTO);

    List<VisitTO> findAllVisitsByPatientId(Long patientId);
}
