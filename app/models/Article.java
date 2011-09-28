package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;

 
@Entity
public class Article extends Model {

	@Required
	public String title;
	public Date postedAt;

	@Lob
	@MaxSize(10000)
	public String summary;

	@Lob
	@MaxSize(10000)
	public String content;

	public Article(String title, String summary, String content){
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.postedAt = new Date();
	}

	public String toString(){
		return title;
	}
	@PrePersist
	public void prePersist() {
    		postedAt = new Date();
	}

}