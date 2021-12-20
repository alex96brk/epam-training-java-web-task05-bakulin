package by.epamtc.bakulin.model;

import java.io.Serializable;

import by.epamtc.bakulin.model.constant.Preciousness;

public class Gem implements Serializable {

	private static final long serialVersionUID = 101016545852L;

	private Long gemId;
	
	private String gemUniqueName;

	private String gemType;

	private GemOriginPlace gemOriginPlace;

	private Preciousness gemPreciousness;

	private String gemColor;

	private String gemTransparency;

	private String gemHardness;

	private Double gemWeightValue;
	
	private String gemAddTimeStamp;

	public Gem(Long gemId, String gemUniqueName, String gemType, GemOriginPlace gemOriginPlace, Preciousness gemPreciousness,
			String gemColor, String gemTransparency, String gemHardness, Double gemWeightValue,
			String gemAddTimeStamp) {
		this.gemId = gemId;
		this.gemUniqueName = gemUniqueName;
		this.gemType = gemType;
		this.gemOriginPlace = gemOriginPlace;
		this.gemPreciousness = gemPreciousness;
		this.gemColor = gemColor;
		this.gemTransparency = gemTransparency;
		this.gemHardness = gemHardness;
		this.gemWeightValue = gemWeightValue;
		this.gemAddTimeStamp = gemAddTimeStamp;
	}
	
	public Gem(GemOriginPlace gemOriginPlace) {
		this.gemOriginPlace = gemOriginPlace;
	}

	public Gem() {
	}

	public Long getGemId() {
		return gemId;
	}

	public void setGemId(Long gemId) {
		this.gemId = gemId;
	}

	public String getGemUniqueName() {
		return gemUniqueName;
	}

	public void setGemUniqueName(String gemUniqueName) {
		this.gemUniqueName = gemUniqueName;
	}

	public String getGemType() {
		return gemType;
	}

	public void setGemType(String gemType) {
		this.gemType = gemType;
	}

	public GemOriginPlace getGemOriginPlace() {
		return gemOriginPlace;
	}

	public void setGemOriginPlace(GemOriginPlace gemOriginPlace) {
		this.gemOriginPlace = gemOriginPlace;
	}

	public Preciousness getGemPreciousness() {
		return gemPreciousness;
	}

	public void setGemPreciousness(Preciousness gemPreciousness) {
		this.gemPreciousness = gemPreciousness;
	}

	public String getGemColor() {
		return gemColor;
	}

	public void setGemColor(String gemColor) {
		this.gemColor = gemColor;
	}

	public String getGemTransparency() {
		return gemTransparency;
	}

	public void setGemTransparency(String gemTransparency) {
		this.gemTransparency = gemTransparency;
	}

	public String getGemHardness() {
		return gemHardness;
	}

	public void setGemHardness(String gemHardness) {
		this.gemHardness = gemHardness;
	}

	public Double getGemWeightValue() {
		return gemWeightValue;
	}

	public void setGemWeightValue(Double gemWeightValue) {
		this.gemWeightValue = gemWeightValue;
	}

	public String getGemAddTimeStamp() {
		return gemAddTimeStamp;
	}

	public void setGemAddTimeStamp(String gemAddTimeStamp) {
		this.gemAddTimeStamp = gemAddTimeStamp;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Gem{");
		sb.append("gemId=").append(gemId);
		sb.append(", gemUniqueName=").append(gemUniqueName);
		sb.append(", gemType=").append(gemType);
		sb.append(", gemOriginPlace=").append(gemOriginPlace.toString());
		sb.append(", gemPreciousness=").append(gemPreciousness);
		sb.append(", gemColor=").append(gemColor);
		sb.append(", gemTransparency=").append(gemTransparency);
		sb.append(", gemHardness=").append(gemHardness);
		sb.append(", gemWeightValue=").append(gemWeightValue);
		sb.append(", gemAddTimeStamp=").append(gemAddTimeStamp);
		sb.append("}");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemAddTimeStamp == null) ? 0 : gemAddTimeStamp.hashCode());
		result = prime * result + ((gemColor == null) ? 0 : gemColor.hashCode());
		result = prime * result + ((gemHardness == null) ? 0 : gemHardness.hashCode());
		result = prime * result + ((gemId == null) ? 0 : gemId.hashCode());
		result = prime * result + ((gemOriginPlace == null) ? 0 : gemOriginPlace.hashCode());
		result = prime * result + ((gemPreciousness == null) ? 0 : gemPreciousness.hashCode());
		result = prime * result + ((gemTransparency == null) ? 0 : gemTransparency.hashCode());
		result = prime * result + ((gemType == null) ? 0 : gemType.hashCode());
		result = prime * result + ((gemUniqueName == null) ? 0 : gemUniqueName.hashCode());
		result = prime * result + ((gemWeightValue == null) ? 0 : gemWeightValue.hashCode());
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
		Gem other = (Gem) obj;
		if (gemAddTimeStamp == null) {
			if (other.gemAddTimeStamp != null)
				return false;
		} else if (!gemAddTimeStamp.equals(other.gemAddTimeStamp))
			return false;
		if (gemColor == null) {
			if (other.gemColor != null)
				return false;
		} else if (!gemColor.equals(other.gemColor))
			return false;
		if (gemHardness == null) {
			if (other.gemHardness != null)
				return false;
		} else if (!gemHardness.equals(other.gemHardness))
			return false;
		if (gemId == null) {
			if (other.gemId != null)
				return false;
		} else if (!gemId.equals(other.gemId))
			return false;
		if (gemOriginPlace == null) {
			if (other.gemOriginPlace != null)
				return false;
		} else if (!gemOriginPlace.equals(other.gemOriginPlace))
			return false;
		if (gemPreciousness != other.gemPreciousness)
			return false;
		if (gemTransparency == null) {
			if (other.gemTransparency != null)
				return false;
		} else if (!gemTransparency.equals(other.gemTransparency))
			return false;
		if (gemType == null) {
			if (other.gemType != null)
				return false;
		} else if (!gemType.equals(other.gemType))
			return false;
		if (gemUniqueName == null) {
			if (other.gemUniqueName != null)
				return false;
		} else if (!gemUniqueName.equals(other.gemUniqueName))
			return false;
		if (gemWeightValue == null) {
			if (other.gemWeightValue != null)
				return false;
		} else if (!gemWeightValue.equals(other.gemWeightValue))
			return false;
		return true;
	}

}
