package com.shashi.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.practice.entity.Student;
import com.shashi.practice.exception.NotfoundException;
import com.shashi.practice.repository.StudentRepo;


@Service
public class StudentService implements StudentDecleration {
	
	@Autowired
	private StudentRepo stdRepo;
	
	@Override
	public List<Student> getAllStd() {
		List<Student> list =stdRepo.findAll();
		return list; 
	}

	@Override
	public void saveStd(Student theStd) {
		System.out.println("from Create");
		stdRepo.save(theStd);
		
	}

	@Override
	public String deleteStdById(int theId) {
		stdRepo.deleteById(theId);
		return "Delete Successfully";
	}

	@Override
	public Student updateStd(int id, Student std) {
		Optional<Student> getStudent = stdRepo.findById(id);
		if(getStudent.isPresent()) {
			Student oldStudent = getStudent.get();
			oldStudent.setName(std.getName());
			oldStudent.setBranch(std.getBranch());
			oldStudent = stdRepo.save(oldStudent);
			return oldStudent;
		}else {
			throw new NotfoundException("No student exist for given id:------ "+ id);
		}
		
	}

	@Override
	public Student findOneStudent(int id) {
		Optional<Student> std = stdRepo.findById(id);
		if(std.isPresent()) {
			return std.get();
		}else {
			throw new NotfoundException("No student exist for given id:----- "+ id);
		}
	}




	

	

}
