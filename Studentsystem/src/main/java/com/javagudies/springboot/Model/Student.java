package com.javagudies.springboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j

//UsingNmaeQuerryAnnotation-Impplemeting custom Query which gives details based on given condition
@NamedQuery(name = "Student.getByNameorAdress", query = " Select s from Student s where s.name=:name or s.adress=:adress")

public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String adress;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( String name, String adress) {
		super();

		this.name = name;
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}




}
