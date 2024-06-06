package com.admin.clinic.dto;

import java.util.List;

import com.admin.clinic.model.Patient;

public class PatientResponseWrapper {
	  private List<Patient> patients;

	    public PatientResponseWrapper(List<Patient> patients) {
	        this.patients = patients;
	    }

	    public List<Patient> getPatients() {
	        return patients;
	    }

	    public void setPatients(List<Patient> patients) {
	        this.patients = patients;
	    }
}
