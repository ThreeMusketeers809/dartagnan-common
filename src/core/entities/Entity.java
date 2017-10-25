package core.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 7418286171609483842L;
	
	private String entityId;
	
	public Entity() {
		setEntityId(null);
	}

	/**
	 * 
	 * Sets the unique ID that identifies this Entity within the service resources
	 * and the database. Typically this ID is assigned by the service and is not
	 * meant to be set or changed by clients.
	 * 
	 * @param entityId
	 *            This Employee's Entity ID.
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	/**
	 * 
	 * @return This Entity's ID.
	 */
	public String getEntityId() {
		return entityId;
	}

}
