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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */

@NamedQueries({
	@NamedQuery(name = "getMovieListById", query = " SELECT m FROM MovieEntry m WHERE m.listId =:listId"),
	@NamedQuery(name = "deleteMovie", query = "DELETE FROM MovieEntry m WHERE m.entryId =:entryId"),
	@NamedQuery(name = "deleteAllMovies", query = "DELETE FROM MovieEntry WHERE listId =:listId")
})

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
	private String imdbId;
	
	@Column(name = "dateAdded")
	private Date dateAdded;
	
	public MovieEntry(long listId, String movieName, String imdbId, Date dateAdded){
		this.entryId = entryId;
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
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
