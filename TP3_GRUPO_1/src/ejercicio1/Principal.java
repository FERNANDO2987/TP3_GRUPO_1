package ejercicio1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Principal {

	
	public static void main(String[] args) {
		
		
		  // TreeSet que almacenará las personas, ordenadas por apellido y sin duplicados
        TreeSet<Persona> listaSinRep = new TreeSet<>();
        
		Archivo archivo = new Archivo();
		archivo.setRuta("D:\\TP3_GRUPO_1\\TP3_GRUPO_1\\src\\Personas.txt");
		
//		  ArrayList<Persona> listaPersonas = archivo.lee_personas();
//		
//		  // Procesar cada persona
//	        for (Persona persona : listaPersonas) {
//	            try {
//	                // Verificar que el DNI sea válido
//	                boolean dniValido = persona.VerificarDniInvalido(persona.getDni());
//	                
//	                // Si el DNI es válido, agregar la persona al TreeSet
//	                if (dniValido) {
//	                    listaSinRep.add(persona);
//	                }
//	            } catch (DniInvalido e) {
//	                // Si el DNI es inválido, mostrar un mensaje y no agregar a la lista
//	                System.out.println("DNI inválido para la persona: " + persona.getNombre() + " " + persona.getApellido());
//	            }
//	        }
//	        
//	        // Imprimir las personas ordenadas por apellido
//	        for (Persona persona : listaSinRep) {
//	            System.out.println(persona.toString());
//	        }

		
		
		 // Leer las personas desde el archivo
        ArrayList<Persona> listaPersonas = archivo.lee_personas();
        
        // Agregar personas válidas al TreeSet
        for (Persona persona : listaPersonas) {
            listaSinRep.add(persona);
        }
        
        // Imprimir las personas ordenadas por apellido
        for (Persona persona : listaSinRep) {
            System.out.println(persona.toString());
        }
	}

}
