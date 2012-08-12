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
import fr.mailjet.util.IWithConstName;

/**
 * Une énumération de toutes les clés pour la méthode {@link MessageRESTService#list(fr.mailjet.rest.EnumReturnType, java.util.Map) }.
 * @see MessageRESTService#list(fr.mailjet.rest.EnumReturnType, java.util.Map)
 * @author Pitton Olivier
 */
public enum EnumMessageListParameters implements IWithConstName {

	/**
	 * Paramètre custom_campaign
	 */
  CUSTOM_CAMPAIGN("custom_campaign"),
	/**
	 * Paramètre from_email
	 */
  FROM_EMAIL("from_email"),
	/**
	 * Paramètre from_name
	 */
  FROM_NAME("from_name"),
	/**
	 * Paramètre limit
	 */
  LIMIT("limit"),
	/**
	 * Paramètre mj_campaign_id
	 */
  MJ_CAMPAIGN_ID("mj_campaign_id"),
	/**
	 * Paramètre sent_after
	 */
  SENT_AFTER("sent_after"),
	/**
	 * Paramètre sent_before
	 */
  SENT_BEFORE("sent_before"),
	/**
	 * Paramètre start
	 */
  START("start"),
	/**
	 * Paramètre to_email
	 */
  TO_EMAIL("to_email");
  
  private String _value;

  private EnumMessageListParameters(String parValue) {
    _value = parValue;
  }

	/**
	 * {@inheritDoc}
	 */
  @Override
  public String getConstName() {
    return _value;
  }

	/**
	 * {@inheritDoc}
	 */
  @Override
  public String toString() {
    return getConstName();
  }
}

