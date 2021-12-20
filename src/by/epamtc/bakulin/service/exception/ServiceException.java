package by.epamtc.bakulin.service.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Exception exception) {
		super(exception);
	}
}
