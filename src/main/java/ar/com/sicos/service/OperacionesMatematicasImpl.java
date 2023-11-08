package ar.com.sicos.service;

import ar.com.sicos.exceptions.DivisionPorZeroException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperacionesMatematicasImpl implements OperacionesMatematicas {


	@Override
	public int suma(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int resta(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int producto(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int division(int a, int b) throws DivisionPorZeroException {

		Optional.of(b)
				.filter(v -> v != 0)
				.orElseThrow(() -> new DivisionPorZeroException("El divisor es 0 "));
		
		return a / b;
	}

}

