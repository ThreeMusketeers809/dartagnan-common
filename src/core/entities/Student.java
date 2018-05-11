package core.entities;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

import core.entities.PhoneNumber;
import core.entities.Student;

/**
 * 
 * This class is a representation of the data and personal details of a school
 * Student.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 *
 */
@XmlRootElement
public class Student extends Person {

	private static final long serialVersionUID = 7065129196728622066L;

	/**
	 * 
	 * Status of the Student within the system.
	 *
	 */
	public enum Status {
		ACTIVE, INACTIVE, SUSPENDED
	};

	private String studentId;
	private String address;
	private Status status;

	/**
	 * 
	 * Constructor.
	 */
	public Student() {
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param studentId
	 *            This Student's school-assigned ID number.
	 * @param firstName
	 *            This Student's first name.
	 * @param middleName
	 *            This Student's middle name.
	 * @param firstSurname
	 *            This Student's first surname, last name, family name or
	 *            equivalent.
	 * @param secondSurname
	 *            This Student's second surname, last name, family name or
	 *            equivalent.
	 * @param cedula
	 *            This Student's government issued ID document.
	 * @param email
	 *            This Student's e-mail address.
	 * @param address
	 *            This Student's mailing address.
	 * @param status
	 *            The status of this Student within the system as a
	 *            {@link #core.Student.Status} element.
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Student.
	 */
	public Student(String studentId, String firstName, String middleName, String firstSurname, String secondSurname,
			String cedula, String email, String address, Status status, List<PhoneNumber> phoneNumbers) {
		setStudentId(studentId);
		setGivenName(firstName);
		setSurname(firstSurname);
		setCedula(cedula);
		setEmail(email);
		setAddress(address);
		setStatus(status);
		setPhoneNumbers(phoneNumbers);
	}

	/**
	 * 
	 * @param studentId
	 *            This Student's school-assigned ID number.
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * 
	 * @return This Student's school-assigned ID number.
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * 
	 * @param address
	 *            This Student's mailing address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return This Student's mailing address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param status
	 *            The status of this Student within the system as a
	 *            {@link #core.Student.Status} element.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 
	 * @param status
	 *            The status of this Student within the system as a String.
	 */
	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	/**
	 * 
	 * @return The status of this Student within the system.
	 */
	public Status getStatus() {
		return status;
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
		} else if (!(object instanceof Student)) {
			return false;
		} else {
			Student s = (Student) object;
			return Objects.equals(getStudentId(), s.getStudentId()) && Objects.equals(getCedula(), s.getCedula());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getStudentId(), getCedula());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = String.format("%s,%s,%s,%s,%s,%s,%s,%s", getEntityId(), getStudentId(), getGivenName(),
				getSurname(), getCedula(), getEmail(), getAddress(),
				getStatus());
		for (PhoneNumber p : getPhoneNumbers()) {
			string += String.format(",%s", p);
		}

		return string;
	}
}