package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.TreatmentType;

import jakarta.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	// Relacja @ManyToOne jednokierunkowa (od strony dziecka)
	@ManyToOne
	@JoinColumn(name = "visit_id")
	private VisitEntity visit;

	public VisitEntity getVisit() {return visit;}
	public void setVisit(VisitEntity visit) {this.visit = visit;}
}
