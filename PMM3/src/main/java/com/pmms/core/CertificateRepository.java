package com.pmms.core;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmms.core.Certificate;

import org.springframework.stereotype.Repository;
@Repository

public interface CertificateRepository extends JpaRepository<Certificate, Serializable> {
}



