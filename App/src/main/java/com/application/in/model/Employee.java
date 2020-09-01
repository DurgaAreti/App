package com.application.in.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8308751827217298119L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@NotNull(message = "Should not be null")
//	@Min(value = 5)
//	@Max(value = 20)
	private String userName;
//	@NotNull(message = "Should not be null")
//	@Min(value = 5, message = "should not be less the 5")
//	@Max(value = 10, message = "Shold not be more the 10")
	private String firstName;
//	@NotNull(message = "Should not be null")
//	@Min(value = 5, message = "should not be less the 5")
//	@Max(value = 10, message = "Shold not be more the 10")
	private String lastName;
//	@NotNull(message = "Should not be null")
//	@Min(value = 8)
	private String password;
//	@NotNull(message = "Should not be null")
//	@Email(message = "Should be email Type")
	private String emailId;

	private String createdDate;
	private String updatedDate;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;

	}

}
