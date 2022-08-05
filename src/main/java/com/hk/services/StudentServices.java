package com.hk.services;

import java.util.List;

import com.hk.api.Student;

public interface StudentServices {

	List<Student> loadStudents();
	   void saveStudent(Student student);
	   Student getStudent(int id);
	void updateStudent(Student student);
	void delete(int id);
	void resetautoinc();
}
