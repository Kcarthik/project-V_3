package com.niit.MuscleMechanic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Supplier {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String supplierName;
	String supplierAddress;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", supplierName=" + supplierName + ", supplierAddress=" + supplierAddress+ "]";
	}


}
