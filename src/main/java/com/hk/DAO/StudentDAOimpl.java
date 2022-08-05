package com.hk.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hk.api.Student;
import com.hk.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudents() {
		String sql="SELECT * FROM school_database.students";
		List<Student> ListofStudents = jdbcTemplate.query(sql,new StudentRowMapper());
		return ListofStudents;
	}

	@Override
	public void saveStudent(Student student) {
		Object[] args= {student.getName(),student.getMobile(),student.getCountry()};
		String sql="insert into school_database.students(name,mobile,country) values(?,?,?)";
		jdbcTemplate.update(sql, args);
		System.out.println("1 record inserted sucessfully");
		
	}

	@Override
	public Student getStudent(int id) {
		String sql="SELECT * FROM school_database.students WHERE ID=?";
		Student stud=jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id);
		return stud;
	}

	@Override
	public void updateStudent(Student student) {
		String sql="update school_database.students set name=?,mobile=?,country=? where id=? ";
		
		
		jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getID());
		System.out.println("1 record updated...");
	}

	@Override
	public void delete(int id) {
		String sql="delete from school_database.students where ID=?";
		
		jdbcTemplate.update(sql,id);
		System.out.println("1 record deleted....");
		
	}

	@Override
	public void resetautoinc() {
        String sql="ALTER TABLE school_database.students AUTO_INCREMENT = 1";
		
		jdbcTemplate.update(sql);
		
		
	}




}
