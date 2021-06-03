package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
	  private String msisdn;
	  
	 @Column(name = "last_login")
	  private String last_login;
	  
	 @Column(name = "password")
	 @NotEmpty(message = "Password can not be empty")
	  private String password;
	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
	  
	  
}
