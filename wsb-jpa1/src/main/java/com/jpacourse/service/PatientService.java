package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.util.List;

public interface PatientService {

    PatientTO findById(final Long id);

    List<PatientTO> findByLastName(final String lastName);

    PatientTO addPatient(PatientTO patientTO);

    void deletePatient(Long patient_id);

}
