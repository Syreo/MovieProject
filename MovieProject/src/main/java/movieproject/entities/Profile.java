package movieproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;



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
	private DateTime birthDate;

}
