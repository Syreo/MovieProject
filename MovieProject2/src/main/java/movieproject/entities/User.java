package movieproject.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.stereotype.Component;
/**
 * User Class
 * @author hyoung
 *
 */

@NamedQueries({
	@NamedQuery(name = "findByUserName", query = " SELECT u FROM User u WHERE u.userName= :userName"),
	@NamedQuery(name = "findByUserId", query = " SELECT u FROM User u WHERE u.userId= :userId"),
	@NamedQuery(name = "findAllUsers", query = " SELECT u FROM User u"),

	
})



@Entity
@Component
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
/**
 * user table
 */

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;

	@Column(name = "userFirstName")
	private String firstName;

	@Column(name = "userLastName")
	private String lastName;

	@Column(name = "userEmail")
	private String email;

	@Column(name = "userName")
	private String userName;

	@Column(name = "userPassword")
	@JsonIgnore
	private String password;
	
	@Column(name = "userBlurb")
	private String blurb;
	
	@Column(name = "userJoinDate")
	private String userJoinDate;
	

/**
 * Constructor
 * @param firstName
 * @param lastName
 * @param userName
 * @param password
 * @param email
 */
	public User(final String firstName, final String lastName,
			final String userName, final String password, String email, String userJoinDate) {
		this.firstName = firstName.substring(0, 1).toUpperCase()
				+ firstName.substring(1);
		this.lastName = lastName.substring(0, 1).toUpperCase()
				+ lastName.substring(1);
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userJoinDate =  userJoinDate;

	}
	


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

/**
 * user
 */
	public User() {
	}



/**
 * @return the blurb
 */
public String getBlurb() {
	return blurb;
}



/**
 * @param blurb the blurb to set
 */
public void setBlurb(String blurb) {
	this.blurb = blurb;
}



public String getUserJoinDate() {
	return userJoinDate;
}



public void setUserJoinDate(String userJoinDate) {
	this.userJoinDate = userJoinDate;
}

	
	
	
}
