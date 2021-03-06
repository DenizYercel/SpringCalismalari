package com.deniz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRETMEN")
public class Ogretmen {
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="ogretmen_seq",sequenceName = "OGRETMEN_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "ogretmen_seq")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="OGRETMEN_DETAY_ID")
	private OgretmenDetay ogretmenDetay;
	
	
	@OneToMany(mappedBy = "ogretmen",cascade = CascadeType.ALL)
	private List<Kurs> kurslar;
	
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;

	
	
	public Ogretmen() {
		super();
	}


	public Ogretmen(OgretmenDetay ogretmenDetay, String firstName, String lastName, String email) {
		super();
		this.ogretmenDetay = ogretmenDetay;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	

	public List<Kurs> getKurslar() {
		return kurslar;
	}

	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OgretmenDetay getOgretmenDetay() {
		return ogretmenDetay;
	}

	public void setOgretmenDetay(OgretmenDetay ogretmenDetay) {
		this.ogretmenDetay = ogretmenDetay;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	@Override
	public String toString() {
		return "Ogretmen [id=" + id + ", ogretmenDetay=" + ogretmenDetay + ", kurslar=" + kurslar + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}


	public void addKurs(Kurs kurs) {
		if(kurslar==null) {
			kurslar=new ArrayList<Kurs>();
		}
			kurslar.add(kurs);
			kurs.setOgretmen(this);
		
	}
	
	
	

}
