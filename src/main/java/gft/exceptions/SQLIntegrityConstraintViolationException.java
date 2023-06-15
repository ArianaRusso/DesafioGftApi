package gft.exceptions;

public class SQLIntegrityConstraintViolationException extends ModelException {

	
	private static final long serialVersionUID = 7466440010963261887L;

	public SQLIntegrityConstraintViolationException(String message) {
		super(message);
		
	}

}
