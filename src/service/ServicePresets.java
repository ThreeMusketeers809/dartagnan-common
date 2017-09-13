package service;

import javax.ws.rs.core.MediaType;

/**
 * 
 * Default options and presets for services.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 * 
 */
public final class ServicePresets {
	public static final String QUERY_SERVICES_PATH = "/io";
	public static final String PRIMARY_OBJECT_MEDIA_TYPE = MediaType.APPLICATION_XML;
	public static final String SECONDARY_OBJECT_MEDIA_TYPE = MediaType.APPLICATION_JSON;
	public static final String FORM_MEDIA_TYPE = MediaType.APPLICATION_FORM_URLENCODED;
}
