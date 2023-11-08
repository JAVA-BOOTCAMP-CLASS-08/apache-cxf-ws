package ar.com.sicos.exceptions;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.ws.WebFault;

@WebFault(name="DivisionPorCero")
@XmlAccessorType( XmlAccessType.FIELD )
public class DivisionPorZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 927759210745518278L;

	public DivisionPorZeroException() {
		this("Division por cero!!!");
	}
	
	public DivisionPorZeroException(String message) {
		super(message);
	}
}
