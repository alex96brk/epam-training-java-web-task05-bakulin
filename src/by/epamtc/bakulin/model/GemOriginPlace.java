package by.epamtc.bakulin.model;

import java.io.Serializable;

public class GemOriginPlace implements Serializable{
	
	private static final long serialVersionUID = 101016545456L;
	
	private String country;
	
	private String town;
	
	private String miningCamp;
	
	public GemOriginPlace(String country, String town, String miningCamp) {
		this.country = country;
		this.town = town;
		this.miningCamp = miningCamp;
	}
	
	public GemOriginPlace() {}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getMiningCamp() {
		return miningCamp;
	}

	public void setMiningCamp(String miningCamp) {
		this.miningCamp = miningCamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((miningCamp == null) ? 0 : miningCamp.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GemOriginPlace other = (GemOriginPlace) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (miningCamp == null) {
			if (other.miningCamp != null)
				return false;
		} else if (!miningCamp.equals(other.miningCamp))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GemOriginPlace{");
		sb.append("country=").append(country);
		sb.append(", town=").append(town);
		sb.append(", miningCamp=").append(miningCamp);
		sb.append("}");
		return sb.toString();
	}
	
}
