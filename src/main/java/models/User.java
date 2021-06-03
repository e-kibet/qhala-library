package models;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "first_name")
	 @NotEmpty(message = "First name can not be empty")
	  private String first_name;
	 
	 @Column(name = "last_name")
	 @NotEmpty(message = "Last name can not be empty")
	  private String last_name;
	 
	 @Column(name = "email_address", unique = true)
	 @NotEmpty(message = "Email address can not be empty")
	  private String email_address;
	  
	 @Column(name = "msisdn", unique = true)
	 @NotEmpty(message = "Phone number can not be empty")
	 @Size(min=10, max=12)
	 @Pattern(regexp = "^(\\+){0,1}(254){0,1}(70|71|72|79)(\\d{7})|(254){0,3}(740|741|742|743|745|746|748|757|758|759|768|769|110|111)(\\d{6})$")
	  private String msisdn;
	  
	 @Column(name = "last_login")
	  private String last_login;
	  
	 @Column(name = "password")
	 @NotEmpty(message = "Password can not be empty")
	  private String password;
	  
	 @Column(name = "created_at")
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	  private Date created_at;
	  
	 @Column(name = "updated_at")
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	  private Date updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	  
	 
	 
	  
}
