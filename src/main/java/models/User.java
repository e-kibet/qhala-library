package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="users")
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", updatable = false)
	  private Integer id;

	 @Column(name = "first_name", updatable = true, nullable = false)
	 @NotEmpty(message = "First name can not be empty")
	  private String first_name;
	 
	 @Column(name = "last_name", updatable = true, nullable = false)
	 @NotEmpty(message = "Last name can not be empty")
	  private String last_name;
	 
	 @Size(min = 4, max = 255, message = "Email address cannot be empty")
	  @Column(name = "email", unique = true, nullable = false, updatable = false)
	  private String email;
	  
	 @Column(name = "msisdn", unique = true, nullable = false, updatable = false)
	 @NotEmpty(message = "Phone number can not be empty")
	 @Size(min=10, max=12)
	 @Pattern(regexp = "^(\\+){0,1}(254){0,1}(70|71|72|79)(\\d{7})|(254){0,3}(740|741|742|743|745|746|748|757|758|759|768|769|110|111)(\\d{6})$")
	  private String msisdn;
	  
	 @Column(name = "last_login")
	  private String last_login;
	 
	 @ElementCollection(fetch = FetchType.EAGER)
	  List<Role> roles;
	  
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@JsonIgnore
	@JsonProperty(value = "password")
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
	  
	public List<Role> getRoles() {
	    return roles;
	  }

	  public void setRoles(List<Role> roles) {
	    this.roles = roles;
	  }
	  
}
