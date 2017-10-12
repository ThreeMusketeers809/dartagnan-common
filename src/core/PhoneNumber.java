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

	private String entityId;
	private String phoneNumber;
	private Type type;

	/**
	 * Constructor.
	 */
	public PhoneNumber() {
		setEntityId(null);
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
		setEntityId(null);
		setPhoneNumber(phoneNumber);
		setType(type);
	}

	/**
	 * 
	 * Sets the unique ID that identifies this Employee within the service and the
	 * database. Typically this ID is assigned by the service and is not meant to be
	 * set or changed by clients.
	 * 
	 * @param entityId
	 *            This PhoneNumber's Entity ID.
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	/**
	 * 
	 * @return This PhoneNumber's Entity ID.
	 */
	public String getEntityId() {
		return entityId;
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
