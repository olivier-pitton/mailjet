package fr.mailjet.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implémentation de base d'un évènement de blocage.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * @author Pitton Olivier
 *
 */
public class BlockMailjetEvent extends AMailjetCampaignEvent {

	private static final long serialVersionUID = -6633905801387434396L;
	/**
	 * L'erreur est liée à
	 */
	@JsonProperty("error_related_to")
	private String _errorRelatedTo;
	/**
	 * L'erreur
	 */
	@JsonProperty("error")
	private String _error;

	/**
	 * Constructeur
	 */
	public BlockMailjetEvent() {
	}

	protected BlockMailjetEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign,
			final String parErrorRelatedTo, final String parError) {
		super(parEvent, parTime, parEmail, parCampaignId, parContactId, parCustomCampaign);
		this._errorRelatedTo = parErrorRelatedTo;
		this._error = parError;
	}

	/**
	 * Retourne ce à quoi est liée l'erreur (domain, destinataire, ...)
	 * @return {@link String} ce à quoi est liée l'erreur (domain, destinataire, ...)
	 */
	public String getErrorRelatedTo() {
		return this._errorRelatedTo;
	}

	/**
	 * Modifie ce à quoi est liée l'erreur (domain, destinataire, ...)
	 * @param parErrorRelatedTo {@link String} ce à quoi est liée l'erreur (domain, destinataire, ...)
	 */
	public void setErrorRelatedTo(final String parErrorRelatedTo) {
		this._errorRelatedTo = parErrorRelatedTo;
	}

	/**
	 * Retourne l'erreur
	 * @return {@link String} l'erreur
	 */
	public String getError() {
		return this._error;
	}

	/**
	 * Modifie l'erreur 
	 * @param parError {@link String} la nouvelle erreur
	 */
	public void setError(final String parError) {
		this._error = parError;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._error == null ? 0 : this._error.hashCode());
		result = prime * result + (this._errorRelatedTo == null ? 0 : this._errorRelatedTo.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object parObject) {
		if (this == parObject)
			return true;
		if (!super.equals(parObject))
			return false;
		if (!(parObject instanceof BlockMailjetEvent))
			return false;
		BlockMailjetEvent other = (BlockMailjetEvent) parObject;
		if (this._error == null) {
			if (other._error != null)
				return false;
		} else if (!this._error.equals(other._error))
			return false;
		if (this._errorRelatedTo == null) {
			if (other._errorRelatedTo != null)
				return false;
		} else if (!this._errorRelatedTo.equals(other._errorRelatedTo))
			return false;
		return true;
	}

}
