package by.epamtc.bakulin.util.xml.exception.handler;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;

public class SaxExceptionHandler implements ErrorHandler {
	
	private static Logger Logger = LogManager.getLogger();
	
	@Override
	public void warning(SAXParseException exception) {
		Logger.warn(getLineColumnNumber(exception) + " - " + exception.getMessage());
	}
	
	@Override
	public void error(SAXParseException exception) {
		Logger.error(getLineColumnNumber(exception) + " - " + exception.getMessage());
	}
	
	@Override
	public void fatalError(SAXParseException exception) {
		Logger.fatal(getLineColumnNumber(exception) + " - " + exception.getMessage());
	}
	
	public void error(SAXException exception) {
		Logger.error(exception.getMessage());
	}
	
	public void error(IOException exception) {
		Logger.error(exception.getMessage());
	}
	
	public void error(ParserConfigurationException exception) {
		Logger.error(exception.getMessage());
	}
	
	public void error(XMLStreamException exception) {
		Logger.error(exception.getMessage());
	}
	
	public void error(ParserNotFoundException exception) {
		Logger.error(exception.getMessage());
	}
	
	private String getLineColumnNumber(SAXParseException exception) {
		return exception.getLineNumber() + " : " + exception.getColumnNumber();
	}

}
