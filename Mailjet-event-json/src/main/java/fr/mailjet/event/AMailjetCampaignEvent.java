package fr.mailjet.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe abstraite contenant un ensemble de paramètres propres à plusieurs
 * types d'évènements.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * 
 * @author Pitton Olivier
 * 
 */
public abstract class AMailjetCampaignEvent extends AMailjetEvent {

	private static final long serialVersionUID = 7559853571818087956L;
	/**
	 * L'adresse email du destinataire qui provoque l'évènement
	 */
	@JsonProperty(value = "email")
	private String _email;
	/**
	 * L'identifiant de campagne
	 */
	@JsonProperty(value = "mj_campaign_id")
	private String _campaignId;
	/**
	 * L'identifiant du contact
	 */
	@JsonProperty(value = "mj_contact_id")
	private String _contactId;
	/**
	 * La valeur de X-Mailjet-Campaign
	 */
	@JsonProperty(value = "customcampaign")
	private String _customCampaign;

	/**
	 * Constructeur
	 */
	protected AMailjetCampaignEvent() {
	}

	protected AMailjetCampaignEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign) {
		super(parEvent, parTime);
		this._email = parEmail;
		this._campaignId = parCampaignId;
		this._contactId = parContactId;
		this._customCampaign = parCustomCampaign;
	}

	/**
	 * Retourne l'identifiant de campagne
	 * 
	 * @return {@link String} l'identifiant de campagne
	 */
	public String getCampaignId() {
		return this._campaignId;
	}

	/**
	 * Retourne l'identifiant du contact
	 * 
	 * @return {@link String} l'identifiant du contact
	 */
	public String getContactId() {
		return this._contactId;
	}

	/**
	 * Retourne la valeur de X-Mailjet-Campaign
	 * 
	 * @return {@link String} la valeur de X-Mailjet-Campaign
	 */
	public String getCustomCampaign() {
		return this._customCampaign;
	}

	/**
	 * Retourne l'adresse email du destinataire qui provoque l'évènement
	 * 
	 * @return {@link String} l'adresse email du destinataire qui provoque
	 *         l'évènement
	 */
	public String getEmail() {
		return this._email;
	}

	/**
	 * Modifie l'identifiant de campagne
	 * 
	 * @param parCampaignId
	 *          {@link String} Le nouvel identifiant de campagne
	 */
	public void setCampaignId(final String parCampaignId) {
		this._campaignId = parCampaignId;
	}

	/**
	 * Modifie l'identifiant du contact
	 * 
	 * @param parContactId
	 *          {@link String} le nouvel identifiant du contact
	 */
	public void setContactId(final String parContactId) {
		this._contactId = parContactId;
	}

	/**
	 * Modifie la valeur de X-Mailjet-Campaign
	 * 
	 * @param parCustomCampaign
	 *          {@link String} la nouvelle valeur de X-Mailjet-Campaign
	 */
	public void setCustomCampaign(final String parCustomCampaign) {
		this._customCampaign = parCustomCampaign;
	}

	/**
	 * Modifie l'adresse email du destinataire qui provoque l'évènement
	 * 
	 * @param parEmail
	 *          {@link String} la nouvelle adresse email du destinataire qui
	 *          provoque l'évènement
	 */
	public void setEmail(final String parEmail) {
		this._email = parEmail;
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
		if (!(parObject instanceof AMailjetCampaignEvent))
			return false;
		AMailjetCampaignEvent other = (AMailjetCampaignEvent) parObject;
		if (this._campaignId == null) {
			if (other._campaignId != null)
				return false;
		} else if (!this._campaignId.equals(other._campaignId))
			return false;
		if (this._contactId == null) {
			if (other._contactId != null)
				return false;
		} else if (!this._contactId.equals(other._contactId))
			return false;
		if (this._customCampaign == null) {
			if (other._customCampaign != null)
				return false;
		} else if (!this._customCampaign.equals(other._customCampaign))
			return false;
		if (this._email == null) {
			if (other._email != null)
				return false;
		} else if (!this._email.equals(other._email))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._campaignId == null ? 0 : this._campaignId.hashCode());
		result = prime * result + (this._contactId == null ? 0 : this._contactId.hashCode());
		result = prime * result + (this._customCampaign == null ? 0 : this._customCampaign.hashCode());
		result = prime * result + (this._email == null ? 0 : this._email.hashCode());
		return result;
	}
}
