package org.cory.rice.bingetv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BingeTvException extends RuntimeException{
	
	public BingeTvException(String message, Exception exception){
		super(message, exception);
	}
	
	public BingeTvException(String message) {
		super(message);
	}
}
