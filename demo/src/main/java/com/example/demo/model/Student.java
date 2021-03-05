package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "student")
public class Student {
	
	 @Id
	 @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "tamil", nullable = false)
	private int tamil;
	@Column(name = "english", nullable = false)
	private int english;
	@Column(name = "maths", nullable = false)
	private int maths;
	@Column(name = "physics", nullable = false)
	private int physics;
	@Column(name = "socialscience", nullable = false)
	private int socialscience;
	@Column(name = "total", nullable = false)
	private int total;
	@Column(name = "passORfail", nullable = false)
	private String passORfail;
	@Column(name = "create_Date", nullable = false)
	@Temporal(TemporalType.DATE)
    @CreatedDate
	private Date create_Date;
	@Column(name = "create_User", nullable = false)
	private String create_User;
	@Column(name = "update_Date")
	private Date update_Date;
	@Column(name = "update_User")
	private  String update_User;
	@Column(name = "percentage")
	private  float percentage;
	
	public Student() {
		
	}

	public Student(int id, String name, int tamil, int english, int maths, int physics, int socialscience, String passORfail,
			Date create_Date, String create_User, Date update_Date, String update_User,int total,float percentage) {
		super();
		this.id = id;
		this.name = name;
		this.tamil = tamil;
		this.english = english;
		this.maths = maths;
		this.physics = physics;
		this.socialscience = socialscience;
		this.create_Date = create_Date;
		this.create_User = create_User;
		this.update_Date = update_Date;
		this.update_User = update_User;
		this.total = total;
		this.passORfail = passORfail;
		this.percentage = percentage;
	}

	

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getPassORfail() {
		return passORfail;
	}

	public void setPassORfail(String passORfail) {
		this.passORfail = passORfail;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getSocialscience() {
		return socialscience;
	}

	public void setSocialscience(int socialscience) {
		this.socialscience = socialscience;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public String getCreate_User() {
		return create_User;
	}

	public void setCreate_User(String create_User) {
		this.create_User = create_User;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	public String getUpdate_User() {
		return update_User;
	}

	public void setUpdate_User(String update_User) {
		this.update_User = update_User;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tamil=" + tamil + ", english=" + english + ", maths=" + maths
				+ ", physics=" + physics + ", socialscience=" + socialscience + ", total=" + total + ", passORfail="
				+ passORfail + ", create_Date=" + create_Date + ", create_User=" + create_User + ", update_Date="
				+ update_Date + ", update_User=" + update_User + ", percentage=" + percentage + "]";
	}


	

	
	
	
	

}
