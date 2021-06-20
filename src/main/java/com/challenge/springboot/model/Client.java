package com.challenge.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;


@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "phone2")
	private String phone2;
	
	@Column(name = "phone_type", nullable = false)
	private String phone_type;
	
	@Column(name = "phone_type2", nullable = false)
	private String phone_type2;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name = "zipcode", nullable = false)
	private String zipcode;
	
	@Column(name = "adress", nullable = false)
	private String address;
	
	@Column(name = "district", nullable = false)
	private String district;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "complement")
	private String complement;
	
	
	public Client () {
		
	}


	public Client(String name, String cpf, String phone, String phone2, String phone_type, String phone_type2,
			String email, String email2, String zipcode, String address, String district, int number, String city,
			String state, String complement) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.phone2 = phone2;
		this.phone_type = phone_type;
		this.phone_type2 = phone_type2;
		this.email = email;
		this.email2 = email2;
		this.zipcode = zipcode;
		this.address = address;
		this.district = district;
		this.number = number;
		this.city = city;
		this.state = state;
		this.complement = complement;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getPhone_type2() {
		return phone_type2;
	}


	public void setPhone_type2(String phone_type2) {
		this.phone_type2 = phone_type2;
	}

	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone_type() {
		return phone_type;
	}
	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
}
