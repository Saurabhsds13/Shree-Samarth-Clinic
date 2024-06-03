package com.admin.clinic.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private Date visitDate;
    private String diagnosis;
    private String prescrption;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getPrescrption() {
		return prescrption;
	}

	public void setPrescrption(String prescrption) {
		this.prescrption = prescrption;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", patient=" + patient + ", visitDate=" + visitDate + ", diagnosis="
				+ diagnosis + ", prescrption=" + prescrption + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

	public MedicalRecord(Long id, Patient patient, Date visitDate, String diagnosis, String prescrption, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.patient = patient;
		this.visitDate = visitDate;
		this.diagnosis = diagnosis;
		this.prescrption = prescrption;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public MedicalRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

