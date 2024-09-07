package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
		FileReader entrada;
		ArrayList<Persona> lista = new ArrayList<Persona>();
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = " ";
			while (linea != null) {
				//lee
				linea = miBuffer.readLine();
				if (linea != "" && linea != null)
				{
					//lo divide en tres campos separados por el guion
					String[] datosPersona = linea.split("-");
					
					//verifico que este todo bien con el vector de datos
					boolean algunError = false;
					for(int i = 0; i < 3; i++)
					{
						if(datosPersona[i] == "" || datosPersona == null)
							algunError = true;
					}
					if (algunError) {
						throw new CargaDeDatosConError();
					}
					
					//creo instancia de persona para rellenarla
					Persona aux = new Persona();
					aux.setNombre(datosPersona[0]);
					aux.setApellido(datosPersona[1]);
					aux.setDni(datosPersona[2]);
					//se agrega a la lista
					lista.add(aux);
				}
				
			}
			miBuffer.close();
			entrada.close();
			
			

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
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
