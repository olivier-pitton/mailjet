package fr.mailjet.rest.parameters;

import fr.mailjet.rest.ApiRESTService;
import fr.mailjet.util.IWithValue;

/**
 * L'énumération de tous les paramètres disponibles de la méthode {@link ApiRESTService#keyAuthenticate(fr.mailjet.rest.EnumReturnType, java.util.List, java.util.Map)}
 * @see ApiRESTService#keyAuthenticate(fr.mailjet.rest.EnumReturnType, java.util.List, java.util.Map)
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public enum EnumKeyAuthenticateParameters implements IWithValue {
	/**
	 * Default page
	 */
	DEFAULT_PAGE("default_page"),
	/**
	 * Langue
	 */
	LANG("lang"),
	/**
	 * Timezone
	 */
	TIMEZONE("timezone"),
	/**
	 * Type
	 */
	TYPE("type");

	final private String _value;
	
	private EnumKeyAuthenticateParameters(final String parValue) {
		_value = parValue;
	}
	
	@Override
	final public String getValue() {
		return _value;
	}
	
	@Override
	public final String toString() {
		return getValue();
	}

}
