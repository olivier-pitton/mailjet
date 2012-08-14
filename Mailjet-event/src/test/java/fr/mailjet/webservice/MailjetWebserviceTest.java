package fr.mailjet.webservice;

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
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Test;

public class MailjetWebserviceTest {

	static final private String URL = "http://localhost:8888/Mailjet-event/mailjet";

	@Test(timeout = 25000L)
	public void testMailjet() throws Exception {
		Logger logger = Logger.getLogger("DEBUG");
		logger.info("Test try to reach " + URL);

		ClientRequest request = new ClientRequest(URL);
		request.accept("application/json");
		request.body(MediaType.APPLICATION_JSON_TYPE, "{}");

		ClientResponse<String> response = request.post(String.class);
		int status = response.getStatus();
		logger.info("Status code " + status);
		Assert.assertEquals(200, status);
	}
}
