package models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import enums.ContentType;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="user_library")
public class UserLibrary {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Enumerated(value=EnumType.STRING)
	 @Column(name = "content_type")
	 @NotEmpty(message = "Content Type is required")
	  private ContentType content_type;
	 
	 @Column(name = "content_id")
	 @NotEmpty(message =  "Content ID is required")
	  private String content_id;
	  
	 @Column(name = "created_at")
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	  private Date created_at;
	  
	 @Column(name = "updated_at")
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	  private Date updated_at;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	 @NotEmpty(message = "User ID is required")
	 @JoinColumn(name = "user_id", nullable = true)
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
