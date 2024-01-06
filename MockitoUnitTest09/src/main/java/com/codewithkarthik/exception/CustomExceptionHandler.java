package com.codewithkarthik.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InputMissingException.class)
	public ResponseEntity<ExceptionResponse> handleException(InputMissingException ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getCode(), new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidAddressException.class)
	public ResponseEntity<ExceptionResponse> handleException(InvalidAddressException ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getCode(), new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ExceptionResponse> handleException(NoRecordFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getCode(), new Date());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleException(RecordNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getCode(), new Date());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleExceptin(UserNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getCode(), new Date());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);

	}

}
