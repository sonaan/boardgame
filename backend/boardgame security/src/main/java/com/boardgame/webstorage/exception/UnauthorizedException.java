package com.boardgame.webstorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
/**
 * Exception regarding request that has not been applied because it lacks valid authentication credentials for the target resource.
 * @author aalexeev
 *
 */
public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
