package core;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * This class is a representation of the data and personal details of a school
 * Employee.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
@XmlRootElement
public class Employee {

	/**
	 * 
	 * Role this employee plays in the system. Possible values are:
	 * <li>{@link #ADMINISTRATOR}}</li>
	 * <li>{@link #COORDINATOR}}</li>
	 * <li>{@link #TEACHER}}</li>
	 * <li>{@link #SUPPORT}}</li>
	 * <li>{@link #UNDEFINED}}</li>
	 *
	 */
	public enum Role {
		/**
		 * Employees with this role have superuser privileges and complete access to all
		 * characteristics of the system.
		 */
		ADMINISTRATOR,
		/**
		 * Employees with this role can organize classes, register teams, students,
		 * teachers and all other logistical tasks pertaining to the school.
		 */
		COORDINATOR,
		/**
		 * Employees with this role can be assigned classes to teach, as well as make
		 * grade reports in their respective classes.
		 */
		TEACHER,
		/**
		 * Employees with this role have read-only access to the information contained
		 * in the system.
		 */
		SUPPORT,
		/**
		 * Employees with this role are special cases with no presets for system access.
		 */
		UNDEFINED
	};

	private int id;
	private String firstName;
	private String middleName;
	private String firstSurname;
	private String secondSurname;
	private String cedula;
	private String email;
	private Role role;
	private List<PhoneNumber> phoneNumbers;

	/**
	 * 
	 * Constructor.
	 */
	public Employee() {
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param id
	 *            This Employee's database PRIMARY KEY id.
	 * @param firstName
	 *            This Employee's first name.
	 * @param middleName
	 *            This Employee's middle name.
	 * @param firstSurname
	 *            This Employee's first surname, last name, family name or
	 *            equivalent.
	 * @param secondSurname
	 *            This Employee's second surname, last name, family name or
	 *            equivalent.
	 * @param cedula
	 *            This Employee's government issued ID document.
	 * @param email
	 *            This Employee's e-mail address.
	 * @param role
	 *            This Employee's system role as a {@link Role} element.
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Employee.
	 */
	public Employee(int id, String firstName, String middleName, String firstSurname, String secondSurname,
			String cedula, String email, Role role, List<PhoneNumber> phoneNumbers) {
		setId(id);
		setFirstName(firstName);
		setMiddleName(middleName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setCedula(cedula);
		setEmail(email);
		setRole(role);
		setPhoneNumbers(phoneNumbers);
	}

	/**
	 * 
	 * @param id
	 *            This Employee's database PRIMARY KEY id.
	 */
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return This Employee's database PRIMARY KEY id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param firstName
	 *            This Employee's first name.
	 */
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return This Employee's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param middleName
	 *            This Employee's middle name.
	 */
	@XmlElement
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * 
	 * @return This Employee's middle name.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * 
	 * @param firstSurname
	 *            This Employee's first surname, last name, family name or
	 *            equivalent.
	 */
	@XmlElement
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * 
	 * @return This Employee's first surname, last name, family name or equivalent.
	 */
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * 
	 * @param secondSurname
	 *            This Employee's second surname, last name, family name or
	 *            equivalent.
	 */
	@XmlElement
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * 
	 * @return This Employee's second surname, last name, family name or equivalent.
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * 
	 * @param cedula
	 *            This Employee's government issued ID document.
	 */
	@XmlElement
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * 
	 * @return This Employee's government issued ID document.
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * 
	 * @param email
	 *            This Employee's e-mail address.
	 */
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return This Employee's e-mail address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param role
	 *            This Employee's system role as a {@link Role} element.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 * @param role
	 *            This Employee's system role formatted as a String.
	 */
	@XmlElement
	public void setRole(String role) {
		this.role = Role.valueOf(role);
	}

	/**
	 * 
	 * @return This Employee's system role.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Employee.
	 */
	@XmlElement
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

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Employee)) {
			return false;
		} else {
			Employee e = (Employee) object;
			if (id == e.getId() && Objects.equals(cedula, e.getCedula())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cedula);
	}
}
