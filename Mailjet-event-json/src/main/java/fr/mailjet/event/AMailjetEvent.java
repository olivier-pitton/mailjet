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
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe de base représentant tous les évènements Mailjet. Cette classe
 * regroupe tous les paramètres que possèdent tous les évènements.
 * Représentation en JSON de la base de tous les évènements. <br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * 
 * @author Pitton Olivier
 * 
 */

public class AMailjetEvent implements Comparable<AMailjetEvent>, Serializable {

	private static final long serialVersionUID = 4116407291020037869L;
	/**
	 * Le type d'évènement
	 */
	@JsonProperty(value = "event", required = true)
	private String _event;
	/**
	 * Le timestamp de l'évènement
	 */
	@JsonProperty(value = "time", required = true)
	private Long _time;

	/**
	 * Constructeur 
	 */
	public AMailjetEvent() {
	}

	/**
	 * Constructeur
	 * @param parEvent {@link String} l'évènement
	 * @param parTime {@link Long} le timestamp de l'évènement
	 */
	public AMailjetEvent(final String parEvent, final Long parTime) {
		super();
		this._event = parEvent;
		this._time = parTime;
	}

	/**
	 * Retournele type d'évènement
	 * @return {@link String} le type d'évènement
	 */
	public String getEvent() {
		return this._event;
	}

	/**
	 * Retourne le timestamp de l'évènement
	 * @return {@link Long} le timestamp de l'évènement
	 */
	public Long getTime() {
		return this._time;
	}

	/**
	 * Modifie le type d'évènement
	 * @param parEvent {@link String} le nouveau type d'évènement
	 */
	public void setEvent(final String parEvent) {
		this._event = parEvent;
	}

	/**
	 * Modifie le timestamp de l'évènement
	 * @param parTime {@link Long} le nouveau timestamp de l'évènement
	 */
	public void setTime(final Long parTime) {
		this._time = parTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this._event;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final AMailjetEvent parEvent) {
		if (parEvent == null)
			return -1;

		int locCompare = this._event.compareTo(parEvent._event);
		return locCompare == 0 ? this._time.compareTo(parEvent._time) : locCompare;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object parObject) {
		if (this == parObject)
			return true;
		if (parObject == null)
			return false;
		if (this.getClass() != parObject.getClass())
			return false;
		AMailjetEvent other = (AMailjetEvent) parObject;
		if (this._event == null) {
			if (other._event != null)
				return false;
		} else if (!this._event.equals(other._event))
			return false;
		if (this._time == null) {
			if (other._time != null)
				return false;
		} else if (!this._time.equals(other._time))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this._event == null ? 0 : this._event.hashCode());
		result = prime * result + (this._time == null ? 0 : this._time.hashCode());
		return result;
	}

}
