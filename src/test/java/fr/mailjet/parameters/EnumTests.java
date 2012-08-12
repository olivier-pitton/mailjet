package fr.mailjet.parameters;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.parameters.EnumContactListParameters;
import fr.mailjet.rest.parameters.EnumCustomStatus;
import fr.mailjet.rest.parameters.EnumKeyAuthenticateParameters;
import fr.mailjet.rest.parameters.EnumListsContactParameters;
import fr.mailjet.rest.parameters.EnumMessageCampaignsParameters;
import fr.mailjet.rest.parameters.EnumMessageListParameters;
import fr.mailjet.util.IWithValue;

/**
 * Tests unitaires des énumérations de paramètres
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
@RunWith(Parameterized.class)
public final class EnumTests {

	/**
	 * Retourne la {@link List} de tous les paramètres à tester.
	 * @see Parameterized
	 * @return {@link List} la liste de tous les paramètres à tester
	 */
	@Parameters
	static public final Collection<Object[]> parameters() {
		final List<Object[]> locParameters = new ArrayList<Object[]>();
		locParameters.add(new Object[]{EnumReturnType.values()});
		locParameters.add(new Object[]{EnumCustomStatus.values()});
		locParameters.add(new Object[]{EnumContactListParameters.values()});
		locParameters.add(new Object[]{EnumListsContactParameters.values()});
		locParameters.add(new Object[]{EnumMessageCampaignsParameters.values()});
		locParameters.add(new Object[]{EnumMessageListParameters.values()});
		locParameters.add(new Object[]{EnumKeyAuthenticateParameters.values()});
		return locParameters;
	}

	private IWithValue[] _enum;
	
	public EnumTests(final IWithValue[] parEnumArray) {
		_enum = parEnumArray;
		assertNotNull(_enum);
		assertTrue(parEnumArray.length > 0);
		assertTrue(parEnumArray[0] instanceof Enum);
	}
	
	@Test(timeout = 3000L)
	public final void testUniqueGetValue() {
		final Set<String> locUniqueSet = new HashSet<String>(_enum.length);
		for(final IWithValue locEnumValue : _enum) {
			assertTrue(" L'élément " + locEnumValue.getValue() + " est déjà présent dans l'énumération " + locEnumValue.getClass() + ".",locUniqueSet.add(locEnumValue.getValue()));
		}
		locUniqueSet.clear();
	}
	
	@Test(timeout = 3000L)
	public final void testIdenticalValueToString() {
		for(final IWithValue locEnumValue : _enum) {
			assertEquals(locEnumValue.getValue(), locEnumValue.toString());
		}
	}
}
