package fr.mailjet.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implémentation de base d'un évènement typofix.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * @author Pitton Olivier
 *
 */
public class TypoFixMailjetEvent extends AMailjetEvent {

	private static final long serialVersionUID = -2942602357461765125L;
	/**
	 * Adresse originale
	 */
	@JsonProperty("original_address")
	private String _originalAddress;
	/**
	 * Nouvelle adresse
	 */
	@JsonProperty("new_address")
	private String _newAddress;

	/**
	 * Constructeur
	 */
	public TypoFixMailjetEvent() {
	}

	protected TypoFixMailjetEvent(final String parEvent, final Long parTime, final String parOriginalAddress, final String parNewAddress) {
		super(parEvent, parTime);
		this._originalAddress = parOriginalAddress;
		this._newAddress = parNewAddress;
	}

	/**
	 * Retourne l'adresse originale
	 * @return {@link String} l'adresse originale
	 */
	public String getOriginalAddress() {
		return this._originalAddress;
	}

	/**
	 * Modifie l'adresse originale
	 * @param parOriginalAddress {@link String} la nouvelle adresse originale
	 */
	public void setOriginalAddress(final String parOriginalAddress) {
		this._originalAddress = parOriginalAddress;
	}

	/**
	 * Retourne la nouvelle adresse
	 * @return {@link String} la nouvelle adresse
	 */
	public String getNewAddress() {
		return this._newAddress;
	}

	/**
	 * Modifie la nouvelle adresse
	 * @param parNewAddress {@link String} la nouvelle adresse
	 */
	public void setNewAddress(final String parNewAddress) {
		this._newAddress = parNewAddress;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._newAddress == null ? 0 : this._newAddress.hashCode());
		result = prime * result + (this._originalAddress == null ? 0 : this._originalAddress.hashCode());
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
		if (!(parObject instanceof TypoFixMailjetEvent))
			return false;
		TypoFixMailjetEvent other = (TypoFixMailjetEvent) parObject;
		if (this._newAddress == null) {
			if (other._newAddress != null)
				return false;
		} else if (!this._newAddress.equals(other._newAddress))
			return false;
		if (this._originalAddress == null) {
			if (other._originalAddress != null)
				return false;
		} else if (!this._originalAddress.equals(other._originalAddress))
			return false;
		return true;
	}

}
