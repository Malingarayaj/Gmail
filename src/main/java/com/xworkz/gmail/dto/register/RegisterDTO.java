package com.xworkz.gmail.dto.register;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "register_table")
public class RegisterDTO implements Serializable {
	public RegisterDTO() {

		System.out.println("Object created for:\t" + this.getClass().getSimpleName());
	}

	private String cname;
	@Id
	private Long cmobileNo;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String email;
	private String location;
	private String education;
	private double experience;
	private String skill;
	private String description;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getCmobileNo() {
		return cmobileNo;
	}

	public void setCmobileNo(Long cmobileNo) {
		this.cmobileNo = cmobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RegisterDTO [cname=" + cname + ", cmobileNo=" + cmobileNo + ", password=" + password + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", location=" + location + ", education=" + education
				+ ", experience=" + experience + ", skill=" + skill + ", description=" + description + "]";
	}

}
