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

	private String uuid;
	private String phoneNumber;
	private Type type;

	/**
	 * Constructor.
	 */
	public PhoneNumber() {
		setUuid(null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param uuid
	 *            This PhoneNumber's database UUID.
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 * @param type
	 *            The type of PhoneNumber the object represents as a
	 *            {@link #core.PhoneNumber.Type} element.
	 */
	public PhoneNumber(String phoneNumber, Type type) {
		setUuid(null);
		setPhoneNumber(phoneNumber);
		setType(type);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param uuid
	 *            This PhoneNumber's database UUID.
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 * @param type
	 *            The type of PhoneNumber the object represents as a
	 *            {@link #core.PhoneNumber.Type} element.
	 */
	public PhoneNumber(String uuid, String phoneNumber, Type type) {
		setUuid(uuid);
		setPhoneNumber(phoneNumber);
		setType(type);
	}

	/**
	 * 
	 * @param uuid
	 *            This PhoneNumber's database UUID.
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 
	 * @return This PhoneNumber's database UUID.
	 */
	public String getUuid() {
		return uuid;
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
	 *            The type of PhoneNumber the object represents as a {@link #core.PhoneNumber.Type}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof PhoneNumber)) {
			return false;
		} else {
			PhoneNumber pn = (PhoneNumber) object;
			return Objects.equals(getUuid(), pn.getUuid()) && Objects.equals(getPhoneNumber(), pn.getPhoneNumber());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getUuid(), getPhoneNumber(), getType());
	}
}
