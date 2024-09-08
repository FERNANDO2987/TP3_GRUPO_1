package ejercicio1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Principal {

	
	public static void main(String[] args) {
		
		
		  // TreeSet que almacenar� las personas, ordenadas por apellido y sin duplicados
        TreeSet<Persona> listaSinRep = new TreeSet<>();
        
		Archivo archivo = new Archivo();
		archivo.setRuta("D:\\TP3_GRUPO_1\\TP3_GRUPO_1\\src\\Personas.txt");
		
//		  ArrayList<Persona> listaPersonas = archivo.lee_personas();
//		
//		  // Procesar cada persona
//	        for (Persona persona : listaPersonas) {
//	            try {
//	                // Verificar que el DNI sea v�lido
//	                boolean dniValido = persona.VerificarDniInvalido(persona.getDni());
//	                
//	                // Si el DNI es v�lido, agregar la persona al TreeSet
//	                if (dniValido) {
//	                    listaSinRep.add(persona);
//	                }
//	            } catch (DniInvalido e) {
//	                // Si el DNI es inv�lido, mostrar un mensaje y no agregar a la lista
//	                System.out.println("DNI inv�lido para la persona: " + persona.getNombre() + " " + persona.getApellido());
//	            }
//	        }
//	        
//	        // Imprimir las personas ordenadas por apellido
//	        for (Persona persona : listaSinRep) {
//	            System.out.println(persona.toString());
//	        }

		
		
		 // Leer las personas desde el archivo
        ArrayList<Persona> listaPersonas = archivo.lee_personas();
        
        // Agregar personas v�lidas al TreeSet
        for (Persona persona : listaPersonas) {
            listaSinRep.add(persona);
        }
        
        // Imprimir las personas ordenadas por apellido
        for (Persona persona : listaSinRep) {
            System.out.println(persona.toString());
        }
	}

}
