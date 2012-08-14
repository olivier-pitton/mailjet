package fr.mailjet.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implémentation de base d'un évènement de retour à l'expéditeur.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * @author Pitton Olivier
 *
 */
public class BounceMailjetEvent extends BlockMailjetEvent {

	private static final long serialVersionUID = 5122897824444847659L;
	/**
	 * Destinataire bloqué
	 */
	@JsonProperty("blocked")
	private Boolean _blocked;
	/**
	 * Opération permanente
	 */
	@JsonProperty("hard_bounce")
	private Boolean _hardBounce;

	/**
	 * Constructeur
	 */
	public BounceMailjetEvent() {
	}

	protected BounceMailjetEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign,
			final String parErrorRelatedTo, final String parError, final Boolean parBlocked, final Boolean parHardBounce) {
		super(parEvent, parTime, parEmail, parCampaignId, parContactId, parCustomCampaign, parErrorRelatedTo, parError);
		this._blocked = parBlocked;
		this._hardBounce = parHardBounce;
	}

	/**
	 * Retourne vrai si le destinataire bloqué
	 * @return {@link Boolean} vrai si le destinataire bloqué
	 */
	public Boolean getBlocked() {
		return this._blocked;
	}

	/**
	 * Modifie le blocage du destinaire
	 * @param parBlocked {@link Boolean} le nouveau blocage du destinataire
	 */
	public void setBlocked(final Boolean parBlocked) {
		this._blocked = parBlocked;
	}

	/**
	 * Retourne vrai si l'opération de blocage est permanente
	 * @return {@link Boolean} vrai si l'opération de blocage est permanente
	 */
	public Boolean getHardBounce() {
		return this._hardBounce;
	}

	/**
	 * Modifie le fait que l'opération est permanente
	 * @param parHardBounce {@link Boolean} la nouvelle valeur de blocage permanent
	 */
	public void setHardBounce(final Boolean parHardBounce) {
		this._hardBounce = parHardBounce;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._blocked == null ? 0 : this._blocked.hashCode());
		result = prime * result + (this._hardBounce == null ? 0 : this._hardBounce.hashCode());
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
		if (!(parObject instanceof BounceMailjetEvent))
			return false;
		BounceMailjetEvent other = (BounceMailjetEvent) parObject;
		if (this._blocked == null) {
			if (other._blocked != null)
				return false;
		} else if (!this._blocked.equals(other._blocked))
			return false;
		if (this._hardBounce == null) {
			if (other._hardBounce != null)
				return false;
		} else if (!this._hardBounce.equals(other._hardBounce))
			return false;
		return true;
	}

}
