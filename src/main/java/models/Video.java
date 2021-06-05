package models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name="videos")
public class Video {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "video_name")
	 @NotNull
	  private String video_name;
	 
	 @Column(name = "video_url")
	 @NotEmpty(message = "Video URL is required")
	  private String video_url;
	 
	 @Column(name = "age_rating")
	 @NotEmpty(message = "Age Rating is required")
	  private String age_rating;

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

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getAge_rating() {
		return age_rating;
	}

	public void setAge_rating(String age_rating) {
		this.age_rating = age_rating;
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
