package by.epamtc.bakulin.util.xml.document.gem.tag;

public enum GemXmlTag {
	GEMS("gems"), 
	GEM("gem"),
	GEM_TYPE("gem_type"),
		COUNTRY("country"), 
		TOWN("town"), 
		MINING_CAMP("mining_camp"),
	GEM_PRECIOUSNESS("gem_preciousness"),
	GEM_COLOR("gem_color"),
	GEM_TRANSPARENCY("gem_transparency"),
	GEM_HARDNESS("gem_hardness"),
	GEM_WEIGHT_VALUE("gem_weight_value"),
	GEM_ADD_TS("gem_add_ts"),
	GEM_ORIGIN_PLACE("gem_origin_place"),
	ATTR_ID("id"),
	ATTR_UNAME("unique_name");
	
	private String tagValue;
	
	GemXmlTag(String tagValue) {
		this.tagValue = tagValue;
	}
	
	public String getTagValue() {
		return tagValue;
	}
}
