package com.Komal.Student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Komal.Student.entity.Student;
import com.Komal.Student.repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/get")
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getById(@PathVariable Long id) {
		return studentRepo.findById(id);
	}
	
	@PostMapping("/add")
	public Student AddStudent(@RequestBody Student  student) {
		return studentRepo.save(student);
		
	}
	
	@PutMapping("/{id}")
	public Student updateById(@PathVariable Long id,@RequestBody Student student) {
		
		Student  student2 = studentRepo.findById(id).get();
		student2.setName(student.getName());
		student2.setEmail(student.getEmail());
		student2.setAddress(student.getAddress());
		student2.setRollNo(student.getRollNo());
		
		return studentRepo.save(student2);
		
	}
	
	@DeleteMapping("/{id}")
	public List<Student> deleteById(@PathVariable Long id) {
		studentRepo.deleteById(id);
		return studentRepo.findAll();
	}

}
