package com.pmm.core;


import java.util.List;

import com.pmm.core.Student;

public interface StudentService {

	public String upsert (Student student);

	public Student getById(Integer id);

	public List<Student> getAllStudents();

	public String deleteById(Integer id);

}
