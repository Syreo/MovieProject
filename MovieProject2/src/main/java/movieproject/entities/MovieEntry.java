/**
 * 
 */
package movieproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */
@Entity
@Component
@Table(name = "movie_entry")
public class MovieEntry implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "entryId")
	private long entryId;
	
	@Column(name = "listId")
	private long listId;
	
	@Column(name = "movieName")
	private String movieName;
	
	@Column(name = "imdbId")
	private long imdbId;
	
	@Column(name = "dateAdded")
	private DateTime dateAdded;
	
	public MovieEntry(long listId, String movieName, long imdbId, DateTime dateAdded){
		this.listId = listId;
		this.imdbId = imdbId;
		this.dateAdded = dateAdded;
		
	}
	public MovieEntry(){
		
	}
	public long getEntryId() {
		return entryId;
	}
	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public long getListId() {
		return listId;
	}
	public void setListId(long listId) {
		this.listId = listId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getImdbId() {
		return imdbId;
	}
	public void setImdbId(long imdbId) {
		this.imdbId = imdbId;
	}
	public DateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(DateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
