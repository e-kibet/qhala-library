package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	 @Column(name = "book_name")
	  private String book_name;
	 
	 @Column(name = "author")
	  private String author;
	 
	 @Column(name = "published_date")
	  private String published_date;
	  
	  
	 @Column(name = "created_at")
	  private String created_at;
	  
	 @Column(name = "updated_at")
	  private String updated_at;
}
