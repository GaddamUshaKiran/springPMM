package com.pmms.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmms.core.Certificate;
import com.pmms.core.CertificateRepository;

@Service
public abstract  class CertificateServiceImpl implements CertificateService {

	@Autowired 
	private CertificateRepository certificateRepo;
	
	@Override
	public String Upsert(Certificate certificate) {
		certificateRepo.save(certificate); //Upset (insert / update on PK)
		return "success";
	}

	@Override
	public Certificate getById(Integer id) {
		Optional<Certificate> findById=certificateRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Certificate> getAllCertificates() {
		return certificateRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(certificateRepo.existsById(id)) {
			certificateRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}



