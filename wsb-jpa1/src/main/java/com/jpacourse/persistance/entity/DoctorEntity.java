package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.Specialization;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String doctorNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	// Relacja @ManyToMany dwukierunkowa
	@ManyToMany()
	@JoinTable(name = "doctor_to_address", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private List<AddressEntity> addresses;

	// Relacja @OneToMany dwukierunkowa
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<VisitEntity> visits = new ArrayList<>();

	public List<AddressEntity> getAddresses() {return addresses;}
	public void setAddresses(List<AddressEntity> addresses) {this.addresses = addresses;}

	public List<VisitEntity> getVisits() {return visits;}
	public void setVisits(List<VisitEntity> visits) {this.visits = visits;}

}
