package ejercicio1;

import java.io.IOException;

public class DniInvalido extends IOException{
	
	public DniInvalido() {}

	@Override
	public String getMessage() {
		return "ERROR: El dni contenia letras";
	}
	
	
}
