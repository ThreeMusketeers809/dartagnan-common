/**
 * 
 */
/**
 * This package contains Entities and other domain objects.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 */
// Set up adapters:
@XmlJavaTypeAdapters({
		// For standard LocalDate
		@XmlJavaTypeAdapter(value = LocalDateAdapter.class, type = LocalDate.class) })
package core.entities;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import core.entities.adapters.LocalDateAdapter;
