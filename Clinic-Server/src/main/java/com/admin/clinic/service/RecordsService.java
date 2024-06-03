package com.admin.clinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.clinic.model.MedicalRecord;
import com.admin.clinic.repository.RecordRepository;
@Service
public class RecordsService {

	@Autowired
	RecordRepository recordrepository;
	
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return recordrepository.save(medicalRecord);
    }
	
	  public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {
	        Optional<MedicalRecord> optionalMedicalRecord = recordrepository.findById(id);
	        if (optionalMedicalRecord.isPresent()) {
	            MedicalRecord existingMedicalRecord = optionalMedicalRecord.get();
	            existingMedicalRecord.setVisitDate(medicalRecord.getVisitDate());
	            existingMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
	            existingMedicalRecord.setPrescrption(medicalRecord.getPrescrption());
	           
	            // Set other fields here as needed
	            return recordrepository.save(existingMedicalRecord);
	        } else {
	            // Handle not found scenario, perhaps throw an exception
	            return null;
	        }
	    }
	  
	  public void deleteMedicalRecord(Long id) {
		  recordrepository.deleteById(id);
	    }
	
	   public MedicalRecord getMedicalRecordById(Long id) {
	        return recordrepository.findById(id).orElse(null);
	    }

	    // Method to retrieve all medical records
	    public List<MedicalRecord> getAllMedicalRecords() {	
	        return recordrepository.findAll();
	    }

	    // Method to retrieve medical records by patient id
	    public List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId) {
	        return recordrepository.findByPatientId(patientId);
	    }
}
