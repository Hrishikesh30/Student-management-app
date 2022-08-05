package com.hk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.DAO.StudentDAO;
import com.hk.api.Student;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	StudentDAO studentDAO;
	@Override
	public List<Student> loadStudents() {
	List<Student> Studentslist = studentDAO.loadStudents();
		return Studentslist;
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	public Student getStudent(int id) {

		return studentDAO.getStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void delete(int id) {
		studentDAO.delete(id);
		
	}

	@Override
	public void resetautoinc() {
		studentDAO.resetautoinc();
		
	}

	

}
