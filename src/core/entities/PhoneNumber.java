package core.entities;

import javax.xml.bind.annotation.XmlRootElement;

import core.entities.Entity;
import core.entities.PhoneNumber;
import util.PhoneNumberValidator;

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
public class PhoneNumber extends Entity {

	private static final long serialVersionUID = 2861383617641725548L;

	/**
	 * 
	 * Type of phone number represented.
	 */
	public enum Type {
		HOME, WORK, MOBILE, FAX, VOIP, OTHER;
	};

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
	 * @param entityId
	 *            This PhoneNumber's Entity ID.
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 * @param type
	 *            The type of PhoneNumber the object represents as a
	 *            {@link #core.PhoneNumber.Type} element.
	 */
	public PhoneNumber(String phoneNumber, Type type) {
		setPhoneNumber(phoneNumber);
		setType(type);
	}

	/**
	 * 
	 * @param phoneNumber
	 *            A String representation of the digits composing this PhoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (PhoneNumberValidator.validate(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IllegalArgumentException("Phone Number is invalid.");
		}
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
	 *            The type of PhoneNumber the object represents as a
	 *            {@link #core.PhoneNumber.Type} element.
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
			return Objects.equals(getPhoneNumber(), pn.getPhoneNumber());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getPhoneNumber(), getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = String.format("%s,%s:%s", getEntityId(), getPhoneNumber(), getType());

		return string;
	}
}
