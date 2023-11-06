package com.pmms.core;

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
import org.springframework.web.bind.annotation.RestController;


import com.pmm.exceptions.CertificateNotFound;

import com.pmms.core.Certificate;
import com.pmms.core.CertificateService;


@RestController

public class CertificateController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private CertificateService certificateService;//reference variable

	@PostMapping("/certificate")
	public ResponseEntity<String> createCertificate(@RequestBody Certificate certificate) {
		String status = certificateService.Upsert(certificate);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/certificate/{id}")
	public ResponseEntity<Certificate> getCertificate(@PathVariable Integer id) {
		Certificate certificate = certificateService.getById(id);
		return new ResponseEntity<>(certificate, HttpStatus.OK);
	}

	@GetMapping("/certificates")
	public ResponseEntity<List<Certificate>> getAllCertificates() {
		List<Certificate> allCertificates = certificateService.getAllCertificates();
		return new ResponseEntity<>(allCertificates, HttpStatus.OK);
	}

	@PutMapping("/certificate")
	public ResponseEntity<String> updateCertificate(@RequestBody Certificate certificate) {
		String status = certificateService.Upsert(certificate);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/certificate/{id}")
	public ResponseEntity<String> deleteCertificate(@PathVariable Integer id) {
		String status = certificateService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	
 
}



