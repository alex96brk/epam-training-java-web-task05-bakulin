package by.epamtc.bakulin.util.xml.validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import by.epamtc.bakulin.util.xml.exception.handler.SaxExceptionHandler;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class XSDValidator {
	
	public static void validateXMLSchema(String xsdPath, String xmlPath) throws SAXException, IOException {
		String shemaLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(shemaLang);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			Source sourceXml = new StreamSource(new File(xmlPath));
			validator.validate(sourceXml);
	}	
}
