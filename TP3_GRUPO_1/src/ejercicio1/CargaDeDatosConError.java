package ejercicio1;

import java.io.IOException;

public class CargaDeDatosConError extends IOException {
	public CargaDeDatosConError() {}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Hubo un problema al leer el archivo";
	}
	
	
}
