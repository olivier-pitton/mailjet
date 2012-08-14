package fr.mailjet.event;

/*
 * 
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(Parameterized.class)
public class JsonProcessingTest {

	static private final ObjectMapper _mapper = new ObjectMapper();

	@Parameters
	static public Collection<Object[]> parameters() {
		List<Object[]> parameters = new ArrayList<Object[]>();
		parameters.add(new Object[] { new ClickMailjetEvent("click", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", null, "82.229.159.100", "FR",
				"http://www.infoq.com/articles/azul_gc_in_detail", "Mozilla\5.0 (X11; Linux x86_64) AppleWebKit\537.1 (KHTML, like Gecko) Chrome\21.0.1180.75 Safari\537.1") });
		parameters.add(new Object[] { new OpenMailjetEvent("open", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", null, "82.229.159.100", "FR",
				"Mozilla\5.0 (X11; Linux x86_64) AppleWebKit\537.1 (KHTML, like Gecko) Chrome\21.0.1180.75 Safari\537.1") });
		parameters.add(new Object[] { new BlockMailjetEvent("block", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", null, "destinataire", "user unknown") });
		parameters
				.add(new Object[] { new BounceMailjetEvent("bounce", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", null, "destinataire", "user unknown", Boolean.TRUE, Boolean.TRUE) });
		parameters.add(new Object[] { new SpamMailjetEvent("spam", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", null, "dummysource") });
		parameters.add(new Object[] { new TypoFixMailjetEvent("typofix", 1344859910L, "192.168.45.67", "10.23.45.54") });
		return parameters;
	}

	final private AMailjetEvent _event;

	public JsonProcessingTest(final AMailjetEvent parEvent) {
		this._event = parEvent;
	}

	@Test(timeout = 10000L)
	public void processJson() throws JsonParseException, JsonMappingException, IOException {
		Assert.assertNotNull(this._event);
		String eventString = JsonProcessingTest._mapper.writeValueAsString(this._event);
		AMailjetEvent newEvent = JsonProcessingTest._mapper.readValue(eventString, _event.getClass());
		Assert.assertEquals(this._event, newEvent);
	}
}
