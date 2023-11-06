package com.pmms.core;

import java.util.List;

import com.pmms.core.Certificate;

public interface CertificateService {

	public String Upsert (Certificate certificate);

	public Certificate getById(Integer id);

	public List<Certificate> getAllUsers();

	public String deleteById(Integer id);

	public List<Certificate> getAllCertificates();

}


