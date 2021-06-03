package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="videos")
public class Video {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "video_name")
	  private String video_name;
	 
	 @Column(name = "video_url")
	  private String video_url;
	 
	 @Column(name = "age_rating")
	  private String age_rating;

	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
}
