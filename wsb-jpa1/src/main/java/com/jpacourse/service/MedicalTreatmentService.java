package com.jpacourse.service;

import com.jpacourse.dto.MedicalTreatmentTO;

public interface MedicalTreatmentService {

    MedicalTreatmentTO findById(Long id);
}