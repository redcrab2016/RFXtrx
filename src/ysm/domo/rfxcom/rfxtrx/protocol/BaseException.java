/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

/**
 * @author edevaux
 *
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	public BaseException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
