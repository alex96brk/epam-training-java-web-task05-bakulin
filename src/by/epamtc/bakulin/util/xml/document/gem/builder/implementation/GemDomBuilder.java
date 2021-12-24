package by.epamtc.bakulin.util.xml.document.gem.builder.implementation;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.model.GemOriginPlace;
import by.epamtc.bakulin.model.constant.Preciousness;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.tag.GemXmlTag;
import by.epamtc.bakulin.util.xml.exception.handler.SaxExceptionHandler;

public class GemDomBuilder extends GemBuilder {

	private Set<Gem> gems;

	private DocumentBuilder documentBuilder;
	
	private SaxExceptionHandler saxExceptionHandler;

	public GemDomBuilder() {
		this.gems = new HashSet<Gem>();
		this.saxExceptionHandler = new SaxExceptionHandler();
		{
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			try {
				this.documentBuilder = docBuilderFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Set<Gem> getGems() {
		return gems;
	}

	@Override
	public void buildGemSet(String xmlPath) {
		Document doc = null;
		try {
			doc = documentBuilder.parse(xmlPath);
			Element root = doc.getDocumentElement();
			NodeList gemList = root.getElementsByTagName(GemXmlTag.GEM.getTagValue());
			for (int i = 0; i < gemList.getLength(); i++) {
				Element gemElement = (Element) gemList.item(i);
				Gem gem = buildGemInstance(gemElement);
				gems.add(gem);
			}
		} catch (SAXException exception) {
			saxExceptionHandler.error(exception);
		} catch (IOException exception) {
			saxExceptionHandler.error(exception);
		}

	}

	private Gem buildGemInstance(Element element) {
		Long gemId;
		String gemUniqueName, gemType, gemColor, gemTransparency, gemHardness, gemAddTimeStamp;
		GemOriginPlace gemOriginPlace;
		Preciousness gemPreciousness;
		Double gemWeightValue;
		{
			gemId = Long.parseLong(element.getAttribute(GemXmlTag.ATTR_ID.getTagValue()));
			gemUniqueName = element.getAttribute(GemXmlTag.ATTR_UNAME.getTagValue());
			gemType = getStringElementTagContent(element, GemXmlTag.GEM_TYPE.getTagValue());
			gemOriginPlace = getGemOriginPlace(element);
			gemPreciousness = getGemPreciousness(element);
			gemColor = getStringElementTagContent(element, GemXmlTag.GEM_COLOR.getTagValue());
			gemTransparency = getStringElementTagContent(element, GemXmlTag.GEM_TRANSPARENCY.getTagValue());
			gemHardness = getStringElementTagContent(element, GemXmlTag.GEM_HARDNESS.getTagValue());
			gemWeightValue = getGemWeightValue(element);
			gemAddTimeStamp = getStringElementTagContent(element, GemXmlTag.GEM_ADD_TS.getTagValue());
		}
		return new Gem(gemId, gemUniqueName, gemType, gemOriginPlace, gemPreciousness, gemColor, gemTransparency,
				gemHardness, gemWeightValue, gemAddTimeStamp);
	}

	private String getStringElementTagContent(Element element, String tagName) {
		NodeList nodeList = element.getElementsByTagName(tagName);
		Node node = nodeList.item(0);
		return node.getTextContent();
	}

	private GemOriginPlace getGemOriginPlace(Element element) {
		String country, town, miningPlace;
		{
			country = getStringElementTagContent(element, GemXmlTag.COUNTRY.getTagValue());
			town = getStringElementTagContent(element, GemXmlTag.TOWN.getTagValue());
			miningPlace = getStringElementTagContent(element, GemXmlTag.MINING_CAMP.getTagValue());
		}
		return new GemOriginPlace(country, town, miningPlace);
	}

	private Preciousness getGemPreciousness(Element element) {
		Preciousness preciousness = null;
		String elementContent = getStringElementTagContent(element, GemXmlTag.GEM_PRECIOUSNESS.getTagValue());
		if (elementContent.equalsIgnoreCase(Preciousness.PRECIOUS.getPreciousnessValue())) {
			preciousness = Preciousness.PRECIOUS;
		}
		if (elementContent.equalsIgnoreCase(Preciousness.SEMI_PRESIOUS.getPreciousnessValue())) {
			preciousness = Preciousness.SEMI_PRESIOUS;
		}
		if (elementContent.equalsIgnoreCase(Preciousness.NON_PRECIOUS.getPreciousnessValue())) {
			preciousness = Preciousness.NON_PRECIOUS;
		}
		return preciousness;
	}

	private Double getGemWeightValue(Element element) {
		String strDouble = getStringElementTagContent(element, GemXmlTag.GEM_WEIGHT_VALUE.getTagValue());
		return Double.parseDouble(strDouble);
	}
	
}
