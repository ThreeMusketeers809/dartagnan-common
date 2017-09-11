package core;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

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
public class Student {
	/**
	 * 
	 * Status of the Student within the system.
	 *
	 */
	public enum Status {
		ACTIVE, INACTIVE, SUSPENDED
	};

	private int id;
	private String studentId;
	private String firstName;
	private String middleName;
	private String firstSurname;
	private String secondSurname;
	private String cedula;
	private String email;
	private String address;
	private Status status;
	private List<PhoneNumber> phoneNumbers;

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
	 * @param id
	 *            This Student's database PRIMARY KEY id.
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
	 *            The status of this Student within the system as a {@link Status}
	 *            element.
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Student.
	 */
	public Student(int id, String studentId, String firstName, String middleName, String firstSurname,
			String secondSurname, String cedula, String email, String address, Status status,
			List<PhoneNumber> phoneNumbers) {
		setId(id);
		setStudentId(studentId);
		setFirstName(firstName);
		setMiddleName(middleName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setCedula(cedula);
		setEmail(email);
		setAddress(address);
		setStatus(status);
		setPhoneNumbers(phoneNumbers);
	}

	/**
	 * 
	 * @param id
	 *            This Student's database PRIMARY KEY id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return This Student's database PRIMARY KEY id.
	 */
	public int getId() {
		return id;
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
	 * @param firstName
	 *            This Student's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return This Student's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param middleName
	 *            This Student's middle name.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * 
	 * @return This Student's middle name.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * 
	 * @param firstSurname
	 *            This Student's first surname, last name, family name or
	 *            equivalent.
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * 
	 * @return This Student's first surname, last name, family name or equivalent.
	 */
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * 
	 * @param secondSurname
	 *            This Student's second surname, last name, family name or
	 *            equivalent.
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * 
	 * @return This Student's first surname, last name, family name or equivalent.
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * 
	 * @param cedula
	 *            This Student's government issued ID document.
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * 
	 * @return This Student's government issued ID document.
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * 
	 * @param email
	 *            This Student's e-mail address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return This Student's e-mail address.
	 */
	public String getEmail() {
		return email;
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
	 *            The status of this Student within the system as a {@link Status}
	 *            element.
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

	/**
	 * 
	 * @param phoneNumbers
	 *            A list of phone numbers associated with this Student.
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * 
	 * @return A list of phone numbers associated with this Student.
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Student)) {
			return false;
		} else {
			Student s = (Student) object;
			return getId() == s.getId() && Objects.equals(getStudentId(), s.getStudentId())
					&& Objects.equals(getCedula(), s.getCedula());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getStudentId(), getCedula());
	}
}