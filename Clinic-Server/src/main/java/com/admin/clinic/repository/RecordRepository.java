package com.admin.clinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.clinic.model.MedicalRecord;

@Repository
public interface RecordRepository  extends JpaRepository<MedicalRecord, Long>{
	  List<MedicalRecord> findByPatientId(Long patientId);
}
