/**
 * 
 */
package io.codingchallenge.healthcare.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.codingchallenge.healthcare.exception.EnrollError;
import io.codingchallenge.healthcare.exception.ServiceException;

/**
 * @author v.huggila
 *
 */
@ControllerAdvice
public class EnrollResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Object> handleServiceException(ServiceException ex, WebRequest request) {

		EnrollError error = new EnrollError();

		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

	}

}
