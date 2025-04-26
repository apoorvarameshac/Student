package com.javagudies.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javagudies.springboot.Model.Student;
import com.javagudies.springboot.Service.StudentService;

import Exception.StudentNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("http://localhost:3000")

@Tag(name = "StudentsService", description = "Operations for managing students data")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Create student data", description = "Save new student data")
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = studentService.insert(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @Operation(summary = "list all students data", description = "Retrieve all students")
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getallStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Operation(summary = "Delete student data by ID", description = "Delete student data by ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        studentService.deletebyid(id);
        return new ResponseEntity<>("Student with ID " + id + " deleted successfully", HttpStatus.OK);
    }

    @Operation(summary = "Update student data", description = "Update student data by ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        Student studentExist = studentService.getByid(id);
        if (studentExist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentExist.setName(student.getName());
        studentExist.setAdress(student.getAdress());
        Student updatedStudent = studentService.update(studentExist);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @Operation(summary = "Get student data by ID", description = "Retrieve student data by ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        Student student = studentService.getByid(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @Operation(summary = "Get student By NameOrAddres", description = "Retrieve student data by NameOrAdress")
    @GetMapping("/GetByAdressOrNmae")
    public  ResponseEntity<Student> FethedBYName   (  @RequestParam(required = false) String name)
            {
    	Student f= studentService.getByNameorAdress(name);
    	if( f== null) {
    	
    		throw new StudentNotFoundException( "Student"+name+" not found in World Try with Registerd name");


    	}
		return null;
    	












    }
}



