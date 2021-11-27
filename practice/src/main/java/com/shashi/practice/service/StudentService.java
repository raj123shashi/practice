package com.shashi.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.practice.entity.Student;
import com.shashi.practice.exception.NotfoundException;
import com.shashi.practice.repository.StudentRepo;


@Service
public class StudentService implements StudentDecleration{
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
	public void updateStd(int id, Student std) {
		Optional<Student> stdId = stdRepo.findById(id);
		Student getStudent =stdId.get();
		getStudent.setBranch(std.getBranch());
		getStudent.setName(std.getName());
		stdRepo.save(getStudent);
		
	}

	@Override
	public Student findOneStudent(int id) throws NotfoundException {
		Student student = stdRepo.findById(id).get();
		 return student;
	}



	

	

}
