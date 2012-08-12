package fr.mailjet.rest.parameters;
/*
 * #%L
 * Mailjet
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

import fr.mailjet.rest.MessageRESTService;
import fr.mailjet.util.IWithValue;


/**
 * Une énumération de toutes les clés pour la méthode {@link MessageRESTService#contacts(fr.mailjet.rest.EnumReturnType, java.lang.Integer, java.util.Map) }
 * @see MessageRESTService#contacts(fr.mailjet.rest.EnumReturnType, Integer, java.util.Map)
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 */
public enum EnumMessageCampaignsParameters implements IWithValue {

	/**
	 * Paramètre limit
	 */
  LIMIT("limit"),
	/**
	 * Paramètre order_by
	 */
  ORDER_BY("order_by"),
	/**
	 * Paramètre start
	 */
  START("start"),
	/**
	 * Paramètre status
	 */
  STATUS("status");
  
  final private String _value;

  private EnumMessageCampaignsParameters(final String parValue) {
    _value = parValue;
  }

  @Override
  public final String getValue() {
    return _value;
  }

  @Override
  public final String toString() {
    return getValue();
  }
}
