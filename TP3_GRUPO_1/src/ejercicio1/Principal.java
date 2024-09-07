package ejercicio1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Principal {

	
	public static void main(String[] args) {
		TreeSet<Persona> listaSinRep = new TreeSet<Persona>();
		Archivo archivo = new Archivo();
		archivo.setRuta("C:/Users/Alejo/Desktop/TP 3/TP3_GRUPO_1/TP3_GRUPO_1/src/Personas.txt");
		
		ArrayList<Persona> lista = archivo.lee_personas();
		
		for(int i = 0; i< lista.size(); i++)
		{
			System.out.println(lista.get(i).toString());
		}

	}

}
