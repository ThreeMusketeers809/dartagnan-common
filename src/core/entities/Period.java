package core.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import core.entities.Entity;
import core.entities.Period;

/**
 * 
 * This class represents a scheduled school period.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
@XmlRootElement
public class Period extends Entity {

	private static final long serialVersionUID = 6252893826420779396L;

	/**
	 * Current status for a {@link #Period}. Possible values: *
	 * <li>{@link #OPEN}}</li>
	 * <li>{@link #CLOSED}}</li>
	 *
	 */
	public enum Status {
		/**
		 * The period is active and can be modified.
		 */
		OPEN,
		/**
		 * The period is inactive and has been archived.
		 */
		CLOSED
	};

	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Status status;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Period() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = Status.valueOf(status);
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
		} else if (!(object instanceof Period)) {
			return false;
		} else {
			Period p = (Period) object;
			return Objects.equals(getName(), p.getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = String.format("%s,%s,%s,%s", getEntityId(), getName(), getStartDate(), getEndDate());

		return string;
	}
}
