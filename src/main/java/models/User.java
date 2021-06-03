package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "first_name")
	  private String first_name;
	 
	 @Column(name = "last_name")
	  private String last_name;
	 
	 @Column(name = "email_address")
	  private String email_address;
	  
	 @Column(name = "msisdn")
	  private String msisdn;
	  
	 @Column(name = "last_login")
	  private String last_login;
	  
	 @Column(name = "password")
	  private String password;
	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
	  
	  
}
