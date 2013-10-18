package movieproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "movie_list")
public class MovieList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "listId")
	private long listId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "listName")
	private String listName;
	
	public MovieList(long userId, String listName){
		this.userId = userId;
		this.listName = listName;
	}
	
	public MovieList(){
		
	}

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
