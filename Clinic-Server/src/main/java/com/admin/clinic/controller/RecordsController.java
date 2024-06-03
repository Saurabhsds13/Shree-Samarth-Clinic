package com.admin.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.clinic.model.MedicalRecord;
import com.admin.clinic.service.RecordsService;

@RestController
@RequestMapping("/records")
public class RecordsController {

	@Autowired
	RecordsService recordservice;

	// End point to create a new medical record
	@PostMapping
	public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		MedicalRecord createdMedicalRecord = recordservice.createMedicalRecord(medicalRecord);
		return new ResponseEntity<>(createdMedicalRecord, HttpStatus.CREATED);
	} 

	// End point to update an existing medical record
	@PutMapping("/{id}")
	public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id,
			@RequestBody MedicalRecord medicalRecord) {
		MedicalRecord updatedMedicalRecord = recordservice.updateMedicalRecord(id, medicalRecord);
		if (updatedMedicalRecord != null) {
			return ResponseEntity.ok(updatedMedicalRecord);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// End point to delete a medical record
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
		recordservice.deleteMedicalRecord(id);
		return ResponseEntity.noContent().build();
	}

	// End point to retrieve a medical record by ID
	@GetMapping("/{id}")
	public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
		MedicalRecord medicalRecord = recordservice.getMedicalRecordById(id);
		if (medicalRecord != null) {
			return ResponseEntity.ok(medicalRecord);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// End point to retrieve all medical records
	@GetMapping("/getAllRecords")
	public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
		List<MedicalRecord> medicalRecords = recordservice.getAllMedicalRecords();
		return ResponseEntity.ok(medicalRecords);
	}

	// End point to retrieve medical records by patient ID
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@PathVariable Long patientId) {
		List<MedicalRecord> medicalRecords = recordservice.getMedicalRecordsByPatientId(patientId);
		return ResponseEntity.ok(medicalRecords);
	}

}