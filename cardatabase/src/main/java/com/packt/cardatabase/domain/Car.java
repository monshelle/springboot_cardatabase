package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNumber;
	@Column(name = "`year`")
	private int year;
	private int price;
	
	public Car() {}
	
	public Car(String brand, String model, String color, 
			String registerNumber, int year, int price, Owner owner) {
		super();
		this.brand=brand;
		this.model=model;
		this.color=color;
		this.registerNumber=registerNumber;
		this.year=year;
		this.price=price;
		this.owner=owner;
	}
	

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Owner getOwner(){
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	/*
	@ManyToMany(mappedBy="cars")
	private Set<Owner>owners=new HashSet<Owner>();

	public Set<Owner> getOwners() {
		return owners;
	}

	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
	*/
	
}
