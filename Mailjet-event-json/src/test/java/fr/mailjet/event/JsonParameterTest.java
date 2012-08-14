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

import junit.framework.Assert;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParameterTest {

	final private ObjectMapper _mapper = new ObjectMapper();

	@Test(timeout = 10000L)
	public void click() throws IOException {
		ClickMailjetEvent event = new ClickMailjetEvent("click", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", "custom", "82.229.159.100", "FR",
				"http://www.infoq.com/articles/azul_gc_in_detail", "Mozilla\5.0 (X11; Linux x86_64) AppleWebKit\537.1 (KHTML, like Gecko) Chrome\21.0.1180.75 Safari\537.1");
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		checkACampaignEvent(event, node);
		Assert.assertEquals(getString(node, "ip"), event.getIp());
		Assert.assertEquals(getString(node, "geo"), event.getGeo());
		Assert.assertEquals(getString(node, "agent"), event.getAgent());
		Assert.assertEquals(getString(node, "url"), event.getUrl());
	}

	@Test(timeout = 10000L)
	public void open() throws IOException {
		OpenMailjetEvent event = new OpenMailjetEvent("open", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", "custom", "82.229.159.100", "FR",
				"Mozilla\5.0 (X11; Linux x86_64) AppleWebKit\537.1 (KHTML, like Gecko) Chrome\21.0.1180.75 Safari\537.1");
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		checkACampaignEvent(event, node);
		Assert.assertEquals(getString(node, "ip"), event.getIp());
		Assert.assertEquals(getString(node, "geo"), event.getGeo());
		Assert.assertEquals(getString(node, "agent"), event.getAgent());
	}

	@Test(timeout = 10000L)
	public void block() throws IOException {
		BlockMailjetEvent event = new BlockMailjetEvent("block", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", "custom", "destinataire", "user unknown");
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		checkACampaignEvent(event, node);
		Assert.assertEquals(getString(node, "error_related_to"), event.getErrorRelatedTo());
		Assert.assertEquals(getString(node, "error"), event.getError());
	}

	@Test(timeout = 10000L)
	public void bounce() throws IOException {
		BounceMailjetEvent event = new BounceMailjetEvent("bounce", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", "custom", "destinataire", "user unknown", Boolean.TRUE,
				Boolean.FALSE);
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		checkACampaignEvent(event, node);
		Assert.assertEquals(getString(node, "error_related_to"), event.getErrorRelatedTo());
		Assert.assertEquals(getString(node, "error"), event.getError());
		Assert.assertEquals(true, get(node, "blocked").asBoolean());
		Assert.assertEquals(false, get(node, "hard_bounce").asBoolean());
	}

	@Test(timeout = 10000L)
	public void spam() throws IOException {
		SpamMailjetEvent event = new SpamMailjetEvent("spam", 1344859910L, "olivier.pitton@gmail.com", "390319834", "241755226", "custom", "dummysource");
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		checkACampaignEvent(event, node);
		Assert.assertEquals(getString(node, "source"), event.getSource());
	}

	@Test(timeout = 10000L)
	public void typofix() throws IOException {
		TypoFixMailjetEvent event = new TypoFixMailjetEvent("typofix", 1344859910L, "192.168.45.67", "10.23.45.54");
		JsonNode node = toNode(event);
		checkAMailjetEvent(event, node);
		Assert.assertEquals(getString(node, "original_address"), event.getOriginalAddress());
		Assert.assertEquals(getString(node, "new_address"), event.getNewAddress());
	}

	private void checkACampaignEvent(AMailjetCampaignEvent parEvent, JsonNode parNode) {
		Assert.assertEquals(getString(parNode, "email"), parEvent.getEmail());
		Assert.assertEquals(getString(parNode, "mj_campaign_id"), parEvent.getCampaignId());
		Assert.assertEquals(getString(parNode, "mj_contact_id"), parEvent.getContactId());
		Assert.assertEquals(getString(parNode, "customcampaign"), parEvent.getCustomCampaign());
	}

	private void checkAMailjetEvent(AMailjetEvent parEvent, JsonNode parNode) {
		Assert.assertEquals(getString(parNode, "event"), parEvent.getEvent());
		Assert.assertEquals(get(parNode, "time").asLong(), parEvent.getTime().longValue());
	}

	private String getString(JsonNode parNode, String parKey) {
		return get(parNode, parKey).asText();
	}

	private JsonNode get(JsonNode parNode, String parKey) {
		return parNode.get(parKey);
	}

	private JsonNode toNode(AMailjetEvent parEvent) throws IOException {
		return _mapper.readTree(_mapper.writeValueAsString(parEvent));
	}

}
