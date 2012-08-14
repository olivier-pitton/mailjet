package fr.mailjet.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implémentation de base d'un évènement de spam.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * @author Pitton Olivier
 *
 */
public class SpamMailjetEvent extends AMailjetCampaignEvent {

	private static final long serialVersionUID = 5828532494334725121L;
	
	/**
	 * Le programme qui a rapporté cette plainte
	 */
	@JsonProperty("source")
	private String _source;

	/**
	 * Constructeur
	 */
	public SpamMailjetEvent() {
	}

	protected SpamMailjetEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign,
			final String parSource) {
		super(parEvent, parTime, parEmail, parCampaignId, parContactId, parCustomCampaign);
		this._source = parSource;
	}

	/**
	 * Retourne le programme qui a rapporté cette plainte 
	 * @return {@link String} le programme qui a rapporté cette plainte
	 */
	public String getSource() {
		return this._source;
	}

	/**
	 * Modifie le programme qui a rapporté cette plainte
	 * @param parSource {@link String} le nouveau programme qui a rapporté cette plainte
	 */
	public void setSource(final String parSource) {
		this._source = parSource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._source == null ? 0 : this._source.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SpamMailjetEvent))
			return false;
		SpamMailjetEvent other = (SpamMailjetEvent) obj;
		if (this._source == null) {
			if (other._source != null)
				return false;
		} else if (!this._source.equals(other._source))
			return false;
		return true;
	}

}
