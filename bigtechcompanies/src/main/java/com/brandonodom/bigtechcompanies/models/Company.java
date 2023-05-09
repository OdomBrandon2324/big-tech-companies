package com.brandonodom.bigtechcompanies.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotBlank(message="Company is required")
	private String  company ;

	@NotBlank(message="Ceo is required")
	private String  ceo;
	
	@NotBlank(message="Location is required")
	private String  location;
	

	@NotNull(message="My date cannot be blank")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	
	//constructors
	public Company()	{
	}
		 public Company(String company, String ceo, Date date, String location, User user) {
			this.company = company;
			this.ceo = ceo;
			this.date = date;
			this.location = location;
			this.user = user;
		}
		 
		 
		 
		public Long getId() {
			return id;
		}
		// createdAt updatedAt automation
	    @PrePersist
	    protected void onCreate() {
	        this.createdAt = new Date();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.updatedAt = new Date();
	    }
		
		public void setId(Long id) {
			this.id = id;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getCeo() {
			return ceo;
		}
		public void setCeo(String ceo) {
			this.ceo = ceo;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		 
		 
		 
		
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
