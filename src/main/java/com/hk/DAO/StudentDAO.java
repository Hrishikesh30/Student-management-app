package com.hk.DAO;

import java.util.List;

import com.hk.api.Student;

public interface StudentDAO {
	
	List<Student> loadStudents();
   void saveStudent(Student student);
   Student getStudent(int id);
void updateStudent(Student student);
void delete(int id);
void resetautoinc();
}
