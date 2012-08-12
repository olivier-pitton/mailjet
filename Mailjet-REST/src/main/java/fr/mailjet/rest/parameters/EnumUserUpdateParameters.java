package fr.mailjet.rest.parameters;
/*
 * #%L
 * Mailjet-REST
 * %%
 * Copyright (C) 2012 Pitton Olivier - olivier dot pitton at gmail dot com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import fr.mailjet.rest.UserRESTService;
import fr.mailjet.util.IWithConstName;

/**
 * L'énumération de toutes les clés pour la méthode
 * {@link UserRESTService#update(fr.mailjet.rest.EnumReturnType, java.util.Map)}
 * .<br /><a  href="https://fr.mailjet.com/docs/api/user/update">Documentation Mailjet</a>
 * 
 * @see UserRESTService#update(fr.mailjet.rest.EnumReturnType, java.util.Map)
 * @author Pitton Olivier
 * 
 */
public enum EnumUserUpdateParameters implements IWithConstName {
	/**
	 * Paramètre address city
	 */
	ADDRESS_CITY("address_city"),
	/**
	 * Paramètre address country
	 */
	ADDRESS_COUNTRY("address_country"),
	/**
	 * Paramètre address postal code
	 */
	ADDRESS_POSTAL_CODE("address_postal_code"),
	/**
	 * Paramètre address street
	 */
	ADDRESS_STREET("address_street"),
	/**
	 * Paramètre company name
	 */
	COMPANY_NAME("company_name"),
	/**
	 * Paramètre contact email
	 */
	CONTACT_EMAIL("contact_email"),
	/**
	 * Paramètre firstname
	 */
	FIRSTNAME("firstname"),
	/**
	 * Paramètre last name
	 */
	LASTNAME("lastname"), 
	/**
	 * Paramètre locale
	 */
	LOCALE("locale");

	private String _name;

	private EnumUserUpdateParameters(String parName) {
		_name = parName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConstName() {
		return _name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return getConstName();
	}

}
