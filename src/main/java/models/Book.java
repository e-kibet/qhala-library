package models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="books")
public class Book {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "book_name")
	 @NotNull
	  private String book_name;
	 
	 @Column(name = "author")
	 @NotNull
	  private String author;
	 
	 @Column(name = "published_date")
	  private String published_date;
	  
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

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublished_date() {
		return published_date;
	}

	public void setPublished_date(String published_date) {
		this.published_date = published_date;
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
