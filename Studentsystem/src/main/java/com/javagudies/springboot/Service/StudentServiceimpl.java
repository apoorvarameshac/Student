package com.javagudies.springboot.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagudies.springboot.Model.Student;
import com.javagudies.springboot.repository.StudentRepository;

import Exception.StudentNotFoundException;

@Service
public  class StudentServiceimpl implements StudentService {


	public StudentServiceimpl() {
		// TODO Auto-generated constructor stub
	}
@Autowired
private StudentRepository studentRepo;
	@Override
	public Student insert(Student student) {
		 return studentRepo.save(student);

		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> getallStudents() {
		 return studentRepo.findAll();

	}



	@Override

	public Student update(Student student) {
		// TODO Auto-generated method stub
		return	studentRepo.save(student);

	}


	@Override
	public Student getByid(Integer id) {
		Optional<Student>  ExistId =studentRepo.findById(id);
		if(ExistId.isPresent()) {
	Student studentId = ExistId.get();
	return studentId;}

		else {
			 throw new StudentNotFoundException(" \"User data not found, please enter a valid user ID"+id);
		 }
			}










	@Override
	public Student deletebyid(int id)  {
	Optional<Student> ischeckId = studentRepo.findById(id);
	 if (ischeckId.isPresent()) {
		 Student  getId = ischeckId.get();
		 studentRepo.delete(getId);
		 return getId;
}
	 else {
		 throw new StudentNotFoundException(" \"Id not found in dataBase "+id);
	 }
}

	@Override
	public Student getByNameorAdress(String name) {

		return studentRepo.findByName(name);
	}


	}
















