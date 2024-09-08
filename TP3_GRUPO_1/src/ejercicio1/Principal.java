package ejercicio1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Principal {

	
	public static void main(String[] args) {
		TreeSet<Persona> listaSinRep = new TreeSet<Persona>();
		Archivo archivo = new Archivo();
		archivo.setRuta("D:\\TP3_GRUPO_1\\TP3_GRUPO_1\\src\\Personas.txt");
		
		ArrayList<Persona> lista = archivo.lee_personas();
		
		for(int i = 0; i< lista.size(); i++)
		{
			Persona persona = lista.get(i);
			try
			{
				 // Verificar el DNI de la persona
                persona.VerificarDniInvalido(persona.getDni());
                System.out.println(persona.toString());
			}
			catch(DniInvalido e)
			{
				 System.out.println("DNI inválido para la persona: " + persona.getNombre() + " " + persona.getApellido() + ". Error: " + e.getMessage());
			}
			
			//System.out.println(lista.get(i).toString());
		}

	}

}
