package by.epamtc.bakulin.model.constant;

import java.io.Serializable;

public enum Preciousness implements Serializable{
	
	PRECIOUS("Precious"), SEMI_PRESIOUS("Semi-Precious"), NON_PRECIOUS("Non-Precious");
	
	private String preciousnessValue;
	
	private Preciousness(String preciousnessValue) {
		this.preciousnessValue = preciousnessValue;
	}

	public String getPreciousnessValue() {
		return preciousnessValue;
	}
	
}
