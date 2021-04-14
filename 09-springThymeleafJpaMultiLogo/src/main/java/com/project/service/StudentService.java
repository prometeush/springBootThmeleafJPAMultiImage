package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.StudentRepository;
import com.project.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public List<Student> studentList(){
		List<Student> list=this.repository.findAll();
		return list;
	}
	
	public Student studentSave(Student student) {
	return	this.repository.save(student);
	}
	
	public void studentDelete(Integer id) {
		this.repository.deleteById(id);
	}
	
	public void studentUpdate(Student student) {
		this.repository.save(student);
	}
	public Student studentFindById(Integer id) {
		Student student=this.repository.findById(id).get();
		return student;
	}

}
