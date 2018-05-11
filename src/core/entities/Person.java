package core.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import util.CedulaValidator;

/**
 * 
 * This class is a representation of the data and personal details of a
 * non-specific Person.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
@XmlRootElement
public class Person extends Entity {

	private static final long serialVersionUID = 1561076542811608612L;

	private String givenName;
	private String surname;
	private String cedula;
	private String email;
	private List<PhoneNumber> phoneNumbers;

	/**
	 * 
	 * @param givenName
	 *            This Person's name.
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * 
	 * @return This Person's given name.
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * 
	 * @param surname
	 *            This Person's surname, last name, family name or equivalent.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * 
	 * @return This Person's surname, last name, family name or equivalent.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * 
	 * @param cedula
	 *            This Person's government issued ID document.
	 */
	public void setCedula(String cedula) {
		if (CedulaValidator.validate(cedula)) {
			this.cedula = cedula;
		} else {
			throw new IllegalArgumentException("Cedula is invalid.");
		}
	}

	/**
	 * 
	 * @return This Person's government issued ID document.
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * 
	 * @param email
	 *            This Person's e-mail address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return This Person's e-mail address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Employee.
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * 
	 * @return A list of phone numbers associated with this Employee.
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
}
