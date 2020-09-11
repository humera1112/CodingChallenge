/**
 * 
 */
package io.codingchallenge.healthcare.exception;

/**
 * @author v.huggila
 *
 */
public class ServiceException extends RuntimeException {

	/**
	 * @param string
	 */
	public ServiceException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
