package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 
 * Abstraction of a Content-Type header, with one or more media type units.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
public class ContentTypeHeader implements Iterable<ContentTypeUnit> {

	private List<ContentTypeUnit> headerUnits;

	/**
	 * 
	 * Constructor.
	 */
	public ContentTypeHeader() {
		headerUnits = new ArrayList<>();
	}

	/**
	 * 
	 * Parses a RFC2616 compliant string representing one or more media types and
	 * their parameters, and generates an object representing it. If the string
	 * contains multiple instances of the same type, these will be updated and
	 * reinserted going from left to right.
	 * 
	 * @param contentTypeHeaderString
	 *            The string to parse.
	 * @return A {@link #util.ContentTypeHeader} object representing the media types
	 *         and associated parameters specified in the string.
	 */
	public static ContentTypeHeader parse(String contentTypeHeaderString) {
		ContentTypeHeader header = new ContentTypeHeader();
		// Split header string
		String[] units = contentTypeHeaderString.split(",");

		for (String unit : units) {
			header.add(ContentTypeUnit.parse(unit));
		}

		return header;
	}

	/**
	 * 
	 * Adds a {@link #util.ContentTypeUnit} representing a media type to this
	 * header. If the specified media type already existed for this header, its
	 * parameters will be updated and it will be reinserted.
	 * 
	 * @param contentTypeUnit
	 *            The unit to be added to this header.
	 * @return true if the header was modified as a result of this call.
	 */
	public boolean add(ContentTypeUnit contentTypeUnit) {
		if (headerUnits.contains(contentTypeUnit)) {
			headerUnits.remove(contentTypeUnit);
		}
		return headerUnits.add(contentTypeUnit);
	}

	/**
	 * 
	 * Removes the media type represented by the provided
	 * {@link #util.ContentTypeUnit} from this header. Please notice that the unit
	 * will be removed on the basis of its media type alone, and any associated
	 * parameters are not taken into consideration.
	 * 
	 * @param contentTypeUnit
	 *            The unit to be removed from this header.
	 * @return true if the header contained the specified unit.
	 */
	public boolean remove(ContentTypeUnit contentTypeUnit) {
		return headerUnits.remove(contentTypeUnit);
	}

	/**
	 * 
	 * Checks if the media type represented by the provided
	 * {@link #util.ContentTypeUnit} exists in this header. Please notice that this
	 * check is performed on the basis of its media type alone, and any associated
	 * parameters are not taken into consideration.
	 * 
	 * @param contentTypeUnit
	 *            The unit to look for in this header.
	 * @return true if the header contains the specified unit.
	 */
	public boolean contains(ContentTypeUnit contentTypeUnit) {
		return headerUnits.contains(contentTypeUnit);
	}

	/**
	 * @return The number of units currently stored in this header.
	 */
	public int size() {
		return headerUnits.size();
	}

	/**
	 * @return true if no units are contained in this header.
	 */
	public boolean isEmpty() {
		return headerUnits.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<ContentTypeUnit> iterator() {
		Collections.sort(headerUnits, Collections.reverseOrder());
		return headerUnits.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		Iterator<ContentTypeUnit> unitIterator = this.iterator();

		while (unitIterator.hasNext()) {
			result += unitIterator.next().toString();
			// Separate next unit with a comma
			if (unitIterator.hasNext()) {
				result += ",";
			}
		}
		return result;
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
		} else if (!(object instanceof ContentTypeHeader)) {
			return false;
		} else {
			ContentTypeHeader cth = (ContentTypeHeader) object;
			return Objects.equals(headerUnits, cth.headerUnits);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(headerUnits);
	}
}
