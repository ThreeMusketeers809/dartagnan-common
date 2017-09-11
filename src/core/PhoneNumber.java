package core;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

/**
 * 
 * This class provides an uniform representation for Phone Numbers.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 *
 */
@XmlRootElement
public class PhoneNumber {

	/**
	 * 
	 * Type of phone number represented.
	 */
	public enum Type {
		HOME, WORK, MOBILE, FAX, VOIP, OTHER;
	};

	private int id;
	private String phoneNumber;
	private Type type;

	/**
	 * Constructor.
	 */
	public PhoneNumber() {
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param id
	 *            This PhoneNumber's database PRIMARY KEY id.
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 * @param type
	 *            The type of PhoneNumber the object represents as a {@link Type}
	 *            element.
	 */
	public PhoneNumber(int id, String phoneNumber, Type type) {
		setId(id);
		setPhoneNumber(phoneNumber);
		setType(type);
	}

	/**
	 * 
	 * @param id
	 *            This PhoneNumber's database PRIMARY KEY id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return This PhoneNumber's database PRIMARY KEY id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @return A String representation of the digits composing this PhoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @param type
	 *            The type of PhoneNumber the object represents as a {@link Type}
	 *            element.
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * 
	 * @param type
	 *            The type of PhoneNumber the object represents formatted as a
	 *            String.
	 */
	public void setType(String type) {
		this.type = Type.valueOf(type);
	}

	/**
	 * 
	 * @return The type of PhoneNumber the object represents.
	 */
	public Type getType() {
		return type;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof PhoneNumber)) {
			return false;
		} else {
			PhoneNumber pn = (PhoneNumber) object;
			return getId() == pn.getId() && Objects.equals(getPhoneNumber(), pn.getPhoneNumber());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getPhoneNumber(), getType());
	}
}
