package core.entities;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import core.entities.Employee;
import core.entities.PhoneNumber;

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
public class Employee extends Person {

	private static final long serialVersionUID = 6776640286851491940L;

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

	private Role role;

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
	 * @param givenName
	 *            This Employee's given name.
	 * @param surname
	 *            This Employee's surname, last name, family name or equivalent.
	 * @param cedula
	 *            This Employee's government issued ID document.
	 * @param email
	 *            This Employee's e-mail address.
	 * @param role
	 *            This Employee's system role as a {@link #core.Employee.Role}
	 *            element.
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Employee.
	 */
	public Employee(String givenName, String surname, String cedula, String email, Role role,
			List<PhoneNumber> phoneNumbers) {
		setGivenName(givenName);
		setSurname(surname);
		setCedula(cedula);
		setEmail(email);
		setRole(role);
		setPhoneNumbers(phoneNumbers);
	}



	/**
	 * 
	 * @param role
	 *            This Employee's system role as a {@link #core.Employee.Role}
	 *            element.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 * @param role
	 *            This Employee's system role formatted as a String.
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Employee)) {
			return false;
		} else {
			Employee e = (Employee) object;
			return Objects.equals(getCedula(), e.getCedula());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getCedula());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = String.format("%s,%s,%s,%s,%s,%s", getEntityId(), getGivenName(), getSurname(),
				getCedula(), getEmail(), getRole());
		for (PhoneNumber p : getPhoneNumbers()) {
			string += String.format(",%s", p);
		}

		return string;
	}
}
