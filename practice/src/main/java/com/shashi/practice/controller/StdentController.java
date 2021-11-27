package com.shashi.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.practice.entity.Student;
import com.shashi.practice.service.StudentService;

@RestController
public class StdentController {
	@Autowired
	private StudentService stdService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student std) {
		stdService.saveStd(std);
		return std;
	}

	@GetMapping("/getAllStudent")
	public List<Student> getStd() {
		return stdService.getAllStd();
	}

	@PutMapping("/studentUpdate/{sid}")
	public Student updateStudente(@PathVariable("sid") Integer id, @RequestBody Student theStd) {
		stdService.updateStd(id, theStd);
		return theStd;
	}

	@DeleteMapping("/delete/{sid}")
	public String delete(@PathVariable("sid") Integer id) {
		System.out.println("from delete");
		return stdService.deleteStdById(id);

	}
	
	@GetMapping("/getAllStudent/{id}")
	public Student getStudentById(@PathVariable("id") Integer id) {
		return stdService.findOneStudent(id);
	}
}
