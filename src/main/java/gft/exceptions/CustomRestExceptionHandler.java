package gft.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import gft.dtos.ApiErrorDTO;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ModelException.class})
	public ResponseEntity<ApiErrorDTO> handleModelException(ModelException ex, WebRequest request){
		
		String error = "Erro no sitema.";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}

	
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
		
		String error = "Recurso não encontrado.";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}
	
	@ExceptionHandler({QuantityUnavailableException.class})
	public ResponseEntity<ApiErrorDTO> handleQuantityUnavailableException(QuantityUnavailableException ex, WebRequest request){
		
		String error = "Quantidade de Peças Indisponível.";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}
	
	@ExceptionHandler({SQLIntegrityConstraintViolationException.class})
	public ResponseEntity<ApiErrorDTO> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest request){
		
		String error = "Cep Invalido. É necessario atualizar dados do endereço.";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}


}
