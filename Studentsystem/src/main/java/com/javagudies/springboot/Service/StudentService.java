package com.javagudies.springboot.Service;

import java.util.List;

import com.javagudies.springboot.Model.Student;

public interface StudentService {
	public Student insert( Student student);
	public List<Student> getallStudents( );

	public Student update(Student student);
	public Student getByid(Integer id );

	Student deletebyid(int id) ;
   Student  getByNameorAdress(String name);

}
