package com.hk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.DAO.StudentDAO;
import com.hk.api.Student;
import com.hk.services.StudentServices;

@Controller
public class StudentController {

	
	@Autowired
	private StudentServices studentServices;

	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> StudentsList = studentServices.loadStudents();

		model.addAttribute("students", StudentsList);
		return "student-list";
	}
	@GetMapping("/add-student")
	public String addnewStudent(Model model) {
		
	Student student=new Student();
		model.addAttribute("student",student);
		
		return "add-student";
	}
	
	@PostMapping("/save-process")
	public String savingStudent(Student student) {
		
	System.out.println(student);
	if(student.getID()==0) {
		studentServices.saveStudent(student);
	}
	else {
		studentServices.updateStudent(student);
	}
	
		return"redirect:/showStudent";
	}
	
	
	
	@GetMapping("/updateStudent")
	public String updatestudent(@RequestParam("UserID") int id,Model model) {
		
		System.out.println("studnt id is "+id);
		Student theStudent=studentServices.getStudent(id);
		System.out.println(theStudent);
		model.addAttribute("student", theStudent);
		return"add-student";
	}
	
	@GetMapping("/deleteStudent")
	public String deletestudent(@RequestParam("UserID") int id) {
		
		System.out.println("studnt id is "+id);
		studentServices.delete(id);
		studentServices.resetautoinc();
		return"redirect:/showStudent";
	}
}
