package com.admin.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.clinic.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}