package com.jpacourse.dto;

import java.io.Serializable;
import java.util.List;

public class AddressTO implements Serializable
{
    private Long id;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postalCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private List<PatientTO> patients;
    private List<DoctorTO> doctors;

    public List<PatientTO> getPatients() {return patients;}
    public void setPatients(List<PatientTO> patients) {this.patients = patients;}

    public List<DoctorTO> getDoctors() {return doctors;}
    public void setDoctors(List<DoctorTO> doctors) {this.doctors = doctors;}

}
