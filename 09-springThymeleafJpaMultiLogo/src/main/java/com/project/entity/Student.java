package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String vorname;
	
	
	private String nachname;
	
	
	private String email;
	

	@Column(name = "prog_sprache")
	private String progSprache;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datum;
	
	
	private String gender;
	
	@Column(name = "main_image")
	private String mainImage;
	
	@Column(name = "extra_image1")
	private String extraImage1;
	
	@Column(name = "extra_image2")
	private String extraImage2;
	
	@Column(name = "extra_image3")
	private String extraImage3;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String vorname, String nachname, String email, String progSprache, Date datum, String gender,
			String mainImage, String extraImage1, String extraImage2, String extraImage3) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.progSprache = progSprache;
		this.datum = datum;
		this.gender = gender;
		this.mainImage = mainImage;
		this.extraImage1 = extraImage1;
		this.extraImage2 = extraImage2;
		this.extraImage3 = extraImage3;
	}

	public Student(Integer id, String vorname, String nachname, String email, String progSprache, Date datum,
			String gender, String mainImage, String extraImage1, String extraImage2, String extraImage3) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.progSprache = progSprache;
		this.datum = datum;
		this.gender = gender;
		this.mainImage = mainImage;
		this.extraImage1 = extraImage1;
		this.extraImage2 = extraImage2;
		this.extraImage3 = extraImage3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgSprache() {
		return progSprache;
	}

	public void setProgSprache(String progSprache) {
		this.progSprache = progSprache;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getExtraImage1() {
		return extraImage1;
	}

	public void setExtraImage1(String extraImage1) {
		this.extraImage1 = extraImage1;
	}

	public String getExtraImage2() {
		return extraImage2;
	}

	public void setExtraImage2(String extraImage2) {
		this.extraImage2 = extraImage2;
	}

	public String getExtraImage3() {
		return extraImage3;
	}

	public void setExtraImage3(String extraImage3) {
		this.extraImage3 = extraImage3;
	}
	
	@Transient
	public String getMainImagePath() {
		if(mainImage==null || id==null) {
			return null;
		}
		return "/student-picture/"+id+"/"+mainImage;
	}
	
	@Transient
	public String getExtraImagePath1() {
		if(extraImage1==null || id==null) {
			return null;
		}
		return "/student-picture/"+id+"/"+extraImage1;
	}
	
	@Transient
	public String getExtraImagePath2() {
		if(extraImage2==null || id==null) {
			return null;
		}
		return "/student-picture/"+id+"/"+extraImage2;
	}
	
	@Transient
	public String getExtraImagePath3() {
		if(extraImage3==null || id==null) {
			return null;
		}
		return "/student-picture/"+id+"/"+extraImage3;
	}

}
