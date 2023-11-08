package ar.com.sicos.service;

import ar.com.sicos.exceptions.DivisionPorZeroException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace="http://cxf.com.ar/matematica")
public interface OperacionesMatematicas {

	@WebMethod(operationName="suma")
	@WebResult(name="resultadoSuma")
    int suma(@WebParam(name="sumando1") int a,
    		 @WebParam(name="sumando2") int b);	
	
	@WebMethod(operationName="resta")
	@WebResult(name="resultadoResta")
    int resta(int a, int b);	
	
	@WebMethod(operationName="producto")
	@WebResult(name="resultadoProducto")
    int producto(int a, int b);	
	
	@WebMethod(operationName="division")
	@WebResult(name="resultadoDivision")
    int division(int a, int b) throws DivisionPorZeroException;
	

	
}

