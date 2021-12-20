package by.epamtc.bakulin.util.xml.document.gem.builder.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.model.GemOriginPlace;
import by.epamtc.bakulin.model.constant.Preciousness;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.tag.GemXmlTag;
import by.epamtc.bakulin.util.xml.exception.handler.SaxExceptionHandler;

public class GemStaxBuilder extends GemBuilder {

	private Set<Gem> gems;

	private XMLInputFactory xmlInputFactory;
	
	private SaxExceptionHandler saxExceptionHandler;

	public GemStaxBuilder() {
		this.gems = new HashSet<Gem>();
		this.xmlInputFactory = XMLInputFactory.newInstance();
		this.saxExceptionHandler = new SaxExceptionHandler();
	}

	public Set<Gem> getGems() {
		return gems;
	}

	@Override
	public void buildGemSet(String xmlPath) {
		
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlPath));
			buildGemInstance(xmlEventReader);
		} catch (FileNotFoundException exception) {
			saxExceptionHandler.error(exception);
		} catch (XMLStreamException exception) {
			saxExceptionHandler.error(exception);
		}
	}

	private void buildGemInstance(XMLEventReader xmlEventReader) throws XMLStreamException {
		GemOriginPlace gemOriginPlace = new GemOriginPlace();
		Gem gem = new Gem();
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			if (xmlEvent.isStartElement()) {
				StartElement startElement = xmlEvent.asStartElement();
				if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM.getTagValue())) {
					Attribute idAttribute = startElement.getAttributeByName(new QName(GemXmlTag.ATTR_ID.getTagValue()));
					gem.setGemId(Long.parseLong(idAttribute.getValue()));
					Attribute uniqueNameAttribute = startElement.getAttributeByName(new QName(GemXmlTag.ATTR_UNAME.getTagValue()));
					gem.setGemUniqueName(uniqueNameAttribute.getValue());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_TYPE.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemType(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.COUNTRY.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gemOriginPlace.setCountry(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.TOWN.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gemOriginPlace.setTown(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.MINING_CAMP.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gemOriginPlace.setMiningCamp(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_PRECIOUSNESS.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					String data = xmlEvent.asCharacters().getData();
					if (data.equalsIgnoreCase(Preciousness.PRECIOUS.getPreciousnessValue())) {
						gem.setGemPreciousness(Preciousness.PRECIOUS);
					}
					if (data.equalsIgnoreCase(Preciousness.SEMI_PRESIOUS.getPreciousnessValue())) {
						gem.setGemPreciousness(Preciousness.SEMI_PRESIOUS);
					}
					if (data.equalsIgnoreCase(Preciousness.NON_PRECIOUS.getPreciousnessValue())) {
						gem.setGemPreciousness(Preciousness.NON_PRECIOUS);
					}
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_COLOR.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemColor(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_TRANSPARENCY.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemTransparency(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_HARDNESS.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemHardness(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_WEIGHT_VALUE.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemWeightValue(Double.parseDouble(xmlEvent.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM_ADD_TS.getTagValue())) {
					xmlEvent = xmlEventReader.nextEvent();
					gem.setGemAddTimeStamp(xmlEvent.asCharacters().getData());
				}

			}
			if (xmlEvent.isEndElement()) {
				EndElement endElement = xmlEvent.asEndElement();
				if (endElement.getName().getLocalPart().equalsIgnoreCase(GemXmlTag.GEM.getTagValue())) {
					gem.setGemOriginPlace(gemOriginPlace);
					gems.add(gem);
				}
			}
		}
	}
}
