package by.epamtc.bakulin.util.xml.document.gem.handler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.model.GemOriginPlace;
import by.epamtc.bakulin.model.constant.Preciousness;
import by.epamtc.bakulin.util.xml.document.gem.tag.GemXmlTag;

public class GemSaxHandler extends DefaultHandler {
	
	private Set<Gem> gems;

	private Gem currentGem;

	private GemXmlTag currentGemTag;

	private EnumSet<GemXmlTag> gemOringinPlaceTagSet;

	private static final String ELEMENT_GEM = GemXmlTag.GEM.getTagValue();

	public GemSaxHandler() {
		gems = new HashSet<Gem>();
		gemOringinPlaceTagSet = EnumSet.range(GemXmlTag.GEM_TYPE, GemXmlTag.GEM_ADD_TS);
	}

	public Set<Gem> getGems() {
		return gems;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (ELEMENT_GEM.equals(qName)) {
			currentGem = new Gem();
			currentGem.setGemOriginPlace(new GemOriginPlace());
			currentGem.setGemId(Long.parseLong(attributes.getValue(0)));
			currentGem.setGemUniqueName(attributes.getValue(1));
		}
		if (!ELEMENT_GEM.equals(qName)) {
			GemXmlTag tagTemp = GemXmlTag.valueOf(qName.toUpperCase());
			if (gemOringinPlaceTagSet.contains(tagTemp)) {
				currentGemTag = tagTemp;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (ELEMENT_GEM.equals(qName)) {
			gems.add(currentGem);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length).trim();
		if (currentGemTag != null) {
			switch (currentGemTag) {
			case GEM_TYPE:
				currentGem.setGemType(data);
				break;
			case COUNTRY:
				currentGem.getGemOriginPlace().setCountry(data);
				break;
			case TOWN:
				currentGem.getGemOriginPlace().setTown(data);
				break;
			case MINING_CAMP:
				currentGem.getGemOriginPlace().setMiningCamp(data);
				break;
			case GEM_PRECIOUSNESS:
				if (data.equalsIgnoreCase(Preciousness.PRECIOUS.getPreciousnessValue())) {
					currentGem.setGemPreciousness(Preciousness.PRECIOUS);
				}
				if (data.equalsIgnoreCase(Preciousness.SEMI_PRESIOUS.getPreciousnessValue())) {
					currentGem.setGemPreciousness(Preciousness.SEMI_PRESIOUS);
				}
				if (data.equalsIgnoreCase(Preciousness.NON_PRECIOUS.getPreciousnessValue())) {
					currentGem.setGemPreciousness(Preciousness.NON_PRECIOUS);
				}
				break;
			case GEM_COLOR:
				currentGem.setGemColor(data);
				break;
			case GEM_TRANSPARENCY:
				currentGem.setGemTransparency(data);
				break;
			case GEM_HARDNESS:
				currentGem.setGemHardness(data);
				break;
			case GEM_WEIGHT_VALUE:
				currentGem.setGemWeightValue(Double.valueOf(data));
				break;
			case GEM_ADD_TS:
				currentGem.setGemAddTimeStamp(data);
				break;
			default:
				throw new EnumConstantNotPresentException(currentGemTag.getClass(), currentGemTag.name());
			}
		}
		currentGemTag = null;
	}

}
