package by.epamtc.bakulin.dao.exception;

@SuppressWarnings("serial")
public class DAOException extends Exception {
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception exception) {
		super(exception);
	}
}