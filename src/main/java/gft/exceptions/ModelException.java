package gft.exceptions;

public class ModelException extends RuntimeException{
		
		private static final long serialVersionUID = -7464808939800278535L;
			
			private String message;
			
			

			public ModelException(String message) {
				super(message);
				this.message = message;
			}



			public String getMessage() {
				return message;
			}



			public void setMessage(String message) {
				this.message = message;
			}

}
