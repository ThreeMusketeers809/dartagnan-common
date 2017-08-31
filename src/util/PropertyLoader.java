package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * A tool to load properties files from CLASSPATH as presets, in Read Only mode.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 *
 */
public class PropertyLoader {
	private String propertiesNamespace;
	private Properties properties;

	/**
	 * 
	 * Constructor.
	 */
	public PropertyLoader() {
	}

	/**
	 * 
	 * Constructor
	 * 
	 * @param propertiesNamespace
	 *            Full namespace descriptor of the properties to be loaded; usually
	 *            in the <b>/package/namespace.properties</b> format.
	 */
	public PropertyLoader(String propertiesNamespace) {
		setPropertyNamespace(propertiesNamespace);
	}

	/**
	 * 
	 * @param propertiesNamespace
	 *            Full namespace descriptor of the properties to be loaded; usually
	 *            in the <b>/package/namespace.properties</b> format.
	 */
	public void setPropertyNamespace(String propertiesNamespace) {
		this.propertiesNamespace = propertiesNamespace;

		InputStream inStream = PropertyLoader.class.getResourceAsStream(this.propertiesNamespace);

		if (inStream != null) {
			properties = new Properties();

			try {
				properties.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.err.printf("Couldn not open: %s", propertiesNamespace);
			System.err.println(System.getProperty("java.class.path"));
		}
	}

	/**
	 * 
	 * @return Full namespace descriptor of the properties currently loaded.
	 */
	public String getPropertiesNamespace() {
		return propertiesNamespace;
	}

	/**
	 * 
	 * @param propertyName
	 *            The name of the saved property to be read.
	 * @return The value stored under the requested name.
	 */
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
