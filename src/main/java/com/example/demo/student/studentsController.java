package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.*;



@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class studentsController {
	@Autowired
	private studentsRepository stuRepo;
	
	@GetMapping("/students")
	public List <student> getAllstudents()
	{
		return stuRepo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Optional<student> getstudentsbyid(@PathVariable String id)
	{
		return stuRepo.findById(id);
	}
	
	@PostMapping("/students")
	public student saveStudent( @RequestBody student student)
	
	{
		
		return stuRepo.save(student);
		
	}
	
	@PutMapping("/students/{id}")
	public student updateStudent( @RequestBody student student, @PathVariable String id)
	
	{
		student currentStudent;
		currentStudent = stuRepo.findById(id).get();
		currentStudent.setFirstName(student.getFirstName());
		currentStudent.setLastName(student.getLastName());
		currentStudent.setStudentNumber(student.getStudentNumber());
		return stuRepo.save(currentStudent);
		
	}
	@DeleteMapping("/students/{id}")
	public void deletestudentsbyid(@PathVariable String id)
	{
		stuRepo.deleteById(id);
	}
}
