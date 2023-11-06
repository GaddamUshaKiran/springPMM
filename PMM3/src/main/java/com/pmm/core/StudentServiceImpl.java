package com.pmm.core;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmm.core.Student;
import com.pmm.core.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired 
	private StudentRepository studentRepo;
	
	@Override
	public String upsert(Student student) {
		studentRepo.save(student); //Upset (insert / update on PK)
		return "success";
	}

	@Override
	public Student getById(Integer id) {
		Optional<Student> findById=studentRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}




