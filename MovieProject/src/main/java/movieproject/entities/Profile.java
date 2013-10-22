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

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@NamedQueries({
	@NamedQuery(name = "findProfileByUserId", query = "SELECT p FROM Profile p WHERE p.userId = :userId")
})


@Entity
@Component
@Table(name = "profile")
public class Profile implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "profileId")
	private long profileId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "userBio")
	private String userBio;
	
	@Column(name = "birthDate")
	private long birthDate;
	
	@Column(name = "top5Movies")
	private String top5Movies;
	
	
	public Profile(long userId, String displayName, String userBio, long birthDate, String top5Movies){
		this.userId = userId;
		this.displayName = displayName;
		this.userBio = userBio;
		this.birthDate = birthDate;
		this.top5Movies = top5Movies;
	}
	
	
	public Profile(){
		
	}


	public long getProfileId() {
		return profileId;
	}


	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getUserBio() {
		return userBio;
	}


	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}


	public long getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(long birthDate) {
		this.birthDate = birthDate;
	}


	public String getTop5Movies() {
		return top5Movies;
	}


	public void setTop5Movies(String top5Movies) {
		this.top5Movies = top5Movies;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
