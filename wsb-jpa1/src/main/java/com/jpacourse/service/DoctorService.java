package com.jpacourse.service;

import com.jpacourse.dto.DoctorTO;

public interface DoctorService {

    DoctorTO findById(Long id);

    DoctorTO addDoctor(DoctorTO doctorTO);
}
