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

	private static final Properties PROPERTIES;

	private static String PROPERTY_PATH = "../epam-training-java-web-task05-bakulin/target/classes/resources/application.properties";

	private static SaxExceptionHandler xmlExeptionHandler;
	
	static {
		PROPERTIES = new Properties();
		xmlExeptionHandler = new SaxExceptionHandler();
		try {
			PROPERTIES.load(new FileInputStream(PROPERTY_PATH));
		} catch (IOException ioException) {
			String message = ioException.getMessage();
			System.out.println(message);
		}
	}
		
	public static boolean validateXMLSchema(String xmlPath) {
		return validateXMLSchema(PROPERTIES.getProperty("xsd.validation.file.path.gem"), xmlPath);
	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		String shemaLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(shemaLang);
		try {
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			Source sourceXml = new StreamSource(new File(xmlPath));
			validator.validate(sourceXml);

		} catch (SAXParseException saxParseException) {
			xmlExeptionHandler.error(saxParseException);
			return false;
		} catch (SAXException saxException) {
			xmlExeptionHandler.error(saxException);
			return false;
		} catch (IOException ioException) {
			xmlExeptionHandler.error(ioException);
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String xmlPath = "C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml";
		boolean isValid = validateXMLSchema( xmlPath);
		if (isValid) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
	}
	
}
