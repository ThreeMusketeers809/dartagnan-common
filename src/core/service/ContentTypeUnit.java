package core.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.core.MediaType;

/**
 * 
 * Abstraction of a single unit of a Content-Type header, with mutable
 * quality-values (q-values) and parameters. This class builds upon
 * {@link #javax.ws.rs.core.MediaType}, and therefore only supports Media Types
 * supported by that class.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
public class ContentTypeUnit implements Comparable<ContentTypeUnit> {

	/**
	 * 
	 * Minimum possible q-value for this object, set at {@value} as per RFC2616
	 * spec.
	 */
	public static final double Q_VALUE_MIN = 0.0;
	/**
	 * 
	 * Maximum possible q-value for this object, set at {@value} as per RFC2616
	 * spec.
	 * 
	 * <p>
	 * Q_VALUE_MAX is used as the default q-value where a different value was not
	 * explicitly indicated, as per RFC2616 spec.
	 * </p>
	 */
	public static final double Q_VALUE_MAX = 1.0;

	private MediaType mediaType;
	private double qValue;
	private Map<String, String> parameters;

	/**
	 * 
	 * Constructor
	 */
	public ContentTypeUnit() {
		setMediaType(MediaType.WILDCARD);
		setQValue(Q_VALUE_MAX);
		setParameters(new HashMap<String, String>());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param mediaType
	 *            The media type the object will represents.
	 * @param qValue
	 *            The q-value associated to the media type. Valid values are in the
	 *            range [{@value #Q_VALUE_MIN}, {@value #Q_VALUE_MAX}}].
	 * @param parameters
	 *            A map with additional parameters associated to the media type. If
	 *            the object passed is null, the class will generate an empty Map.
	 */
	public ContentTypeUnit(MediaType mediaType, double qValue, Map<String, String> parameters) {
		setMediaType(mediaType);
		setQValue(qValue);
		setParameters(parameters);
	}

	/**
	 * @param mediaType
	 */
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @param mediaType
	 *            The media type the object will represents.
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = MediaType.valueOf(mediaType);
	}

	/**
	 * @param qValue
	 *            The q-value associated to the media type. Valid values are in the
	 *            range [{@value #Q_VALUE_MIN}, {@value #Q_VALUE_MAX}}]
	 */
	public void setQValue(double qValue) {
		if (qValue >= Q_VALUE_MIN && qValue <= Q_VALUE_MAX) {
			this.qValue = qValue;
		} else {
			throw new IllegalArgumentException(
					String.format("Only values between Q_VALUE_MIN=%.1f and Q_VALUE_MAX=%.1f (inclusive) are allowed",
							Q_VALUE_MIN, Q_VALUE_MAX));
		}
	}

	/**
	 * @param parameters
	 *            A map with additional parameters associated to the media type. If
	 *            the object passed is null, the class will generate an empty Map.
	 */
	public void setParameters(Map<String, String> parameters) {
		if (parameters == null) {
			this.parameters = new HashMap<String, String>();
		} else {
			this.parameters = parameters;
		}
	}

	/**
	 * @return A map of additional parameters contained in this object.
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * @return The media type represented by this object.
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * @return The q-value associated with the media type represented by this
	 *         object.
	 */
	public double getQValue() {
		return qValue;
	}

	/**
	 * 
	 * Checks if the indicated parameter has been set for this object.
	 * 
	 * @param parameterName
	 *            The name of the parameter to check.
	 * @return true if the indicated parameter has been set for this object.
	 */
	public boolean containsParameter(String parameterName) {
		return parameters.containsKey(parameterName);
	}

	/**
	 * 
	 * Sets the indicated parameter for this object, adding it if it had not been
	 * previously set and updating it to the new value if it was.
	 * 
	 * @param parameterName
	 *            The name of the parameter to set.
	 * @param value
	 *            The value to set this parameter to.
	 * @return The previous value associated to the parameter name, or null if it
	 *         had not been previously set. Note that a response of null does not
	 *         necessarily indicate that the parameter had not been previously set,
	 *         as it might have been set to null.
	 */
	public String putParameter(String parameterName, String value) {
		return parameters.put(parameterName, value);
	}

	/**
	 * 
	 * Removes a parameter associated to this object.
	 * 
	 * @param parameterName
	 *            The name of the parameter to remove,
	 * @return The previous value associated to the parameter name, or null if it
	 *         had not been previously set. Note that a response of null does not
	 *         necessarily indicate that the parameter had not been previously set,
	 *         as it might have been set to null.
	 */
	public String removeParameter(String parameterName) {
		return parameters.remove(parameterName);
	}

	/**
	 * 
	 * Parses a RFC2616 compliant string representing a <b>single</b> media type,
	 * and generates an object representing it.
	 * 
	 * @param contentTypeString
	 *            The string to parse.
	 * @return A {@link #util.ContentTypeUnit} object representing the media type
	 *         and parameters specified in the string.
	 */
	public static ContentTypeUnit parse(String contentTypeString) {
		MediaType mt;
		double qv = 1.0;
		Map<String, String> pmt = new HashMap<String, String>();

		String[] parts = contentTypeString.split(";");

		/*
		 * For a properly formed content-type string, the first part must correspond to
		 * a type/subtype pair, parsable by MediaType
		 */
		mt = MediaType.valueOf(parts[0].trim());

		// Iterate over the remaining parts
		for (int i = 1; i < parts.length; i++) {
			// Split the key=value pairs
			String[] pair = parts[i].split("=");

			// Pairs must have length==2, otherwise content-type string is malformed
			if (pair.length == 2) {
				// Check if q-value is passed in parameters
				if (pair[0].trim().equals("q")) {
					qv = Double.parseDouble(pair[1].trim());
				} else {
					pmt.put(pair[0].trim(), pair[1].trim());
				}
			} else {
				throw new IllegalArgumentException(
						String.format("\"%s\" is not a valid content-type string.", contentTypeString));
			}
		}

		return new ContentTypeUnit(mt, qv, pmt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String resultString = "";

		resultString += getMediaType().toString();

		// If qValue == Q_VALUE_MAX, it can be omitted
		if (getQValue() != Q_VALUE_MAX) {
			resultString += String.format(";%.1f", getQValue());
		}

		// Add optional parameters
		for (Map.Entry<String, String> entry : getParameters().entrySet()) {
			resultString += String.format(";%s=%s", entry.getKey(), entry.getValue());
		}

		return resultString;
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
		} else if (!(object instanceof ContentTypeUnit)) {
			return false;
		} else {
			ContentTypeUnit ct = (ContentTypeUnit) object;
			return Objects.equals(getMediaType(), ct.getMediaType());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getMediaType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ContentTypeUnit contentType) {
		return Objects.compare(this, contentType, new ContentTypeUnitComparator());
	}

	/**
	 * Comparator implementation with the default comparison and ranking logic used
	 * by this the {@link #util.ContentTypeUnit} class.
	 * 
	 * <p>
	 * Media types get ranked based on their q-values. The highest q-value always
	 * has the most precedence. If two objects have the same q-value but one of them
	 * represents a wildcard media type object, the non-wildcard media type object
	 * will get precedence.
	 * <p>
	 *
	 */
	public static class ContentTypeUnitComparator implements Comparator<ContentTypeUnit> {

		@Override
		public int compare(ContentTypeUnit arg0, ContentTypeUnit arg1) {
			int result;

			if (arg0.getQValue() > arg1.getQValue()) {
				result = 1;
			} else if (arg0.getQValue() < arg1.getQValue()) {
				result = -1;
			} else {
				/*
				 * WILDCARD DEFAULTING: Wildcard types are always given less precedence when
				 * compared to non-wildcard types of the same q-value
				 */
				if (!arg0.getMediaType().equals(MediaType.WILDCARD_TYPE)
						&& arg1.getMediaType().equals(MediaType.WILDCARD_TYPE)) {
					result = 1;
				} else if (arg0.getMediaType().equals(MediaType.WILDCARD_TYPE)
						&& !arg1.getMediaType().equals(MediaType.WILDCARD_TYPE)) {
					result = -1;
				} else {
					result = 0;
				}
			}
			return result;
		}
	}
}
