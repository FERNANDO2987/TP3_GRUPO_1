package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Archivo {
	
	private String ruta;
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public boolean creaArchivo()
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}

	public void escribe_letra_x_letra(String frase) {
		try {
			FileWriter fw = new FileWriter(ruta, true);
	
			for (int i = 0; i < frase.length(); i++) {
					fw.write(frase.charAt(i));
				}
			//fw.write(33); //Puede escribir caracteres
			//fw.write(frase); //Puede escribir frases enteras			
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_letra_x_letra() {

		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read(); //Lee el primer caracter
			while (c != -1) 
			{
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			entrada.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void escribe_lineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	public ArrayList<Persona> lee_personas() {
	    ArrayList<Persona> lista = new ArrayList<>();
	    
	    try (FileReader entrada = new FileReader(ruta);
	         BufferedReader miBuffer = new BufferedReader(entrada)) {
	        
	        String linea;
	        while ((linea = miBuffer.readLine()) != null) {
	            if (!linea.trim().isEmpty()) {
	                // Dividir la línea en tres partes: Nombre - Apellido - DNI
	                String[] datosPersona = linea.split("-");
	                
	                // Verificar que los datos estén completos (deben ser 3 partes)
	                if (datosPersona.length == 3) {
	                    String nombre = datosPersona[0].trim();
	                    String apellido = datosPersona[1].trim();
	                    String dni = datosPersona[2].trim();

	                    // Validar que el DNI solo tenga números
	                    try {
	                        Persona persona = new Persona(nombre, apellido, dni);
	                        if (persona.VerificarDniInvalido(dni)) {
	                            lista.add(persona);  // Agregar persona a la lista si el DNI es válido
	                        }
	                    } catch (DniInvalido e) {
	                        System.out.println("DNI inválido para " + nombre + " " + apellido + ": " + dni);
	                    }
	                } else {
	                    System.out.println("Error en la línea: " + linea + ". Debe contener Nombre, Apellido y DNI.");
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("No se encontró el archivo: " + ruta);
	    }
	    
	    return lista;
	}


	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
