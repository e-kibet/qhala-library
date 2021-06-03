package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_library")
public class UserLibrary {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "content_type")
	  private String content_type;
	 
	 @Column(name = "content_id")
	  private String content_id;
	 
	 @Column(name = "user_id")
	  private String user_id;
	  
	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
}
