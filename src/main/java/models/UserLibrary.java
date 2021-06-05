package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enums.ContentType;

@Entity
@Table(name="user_library")
public class UserLibrary {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	
	
	 @Enumerated(value=EnumType.STRING)
	 @Column(name = "content_type")
	  private ContentType content_type;
	 
	 @Column(name = "content_id")
	  private String content_id;
	  
	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContentType getContent_type() {
		return content_type;
	}

	public void setContent_type(ContentType content_type) {
		this.content_type = content_type;
	}

	public String getContent_id() {
		return content_id;
	}

	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}


	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	 
	 
}
