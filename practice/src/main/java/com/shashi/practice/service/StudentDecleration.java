package com.shashi.practice.service;

import java.util.List;
import java.util.Optional;

import com.shashi.practice.entity.Student;



public interface StudentDecleration {
	    public List<Student> getAllStd();
	    
		public void saveStd(Student theStd);
		
		public String deleteStdById(int theId);
		
		public Student updateStd( int id , Student std);
		
		public Student findOneStudent(int id);
		

}
