package ejercicio1;


public class Persona implements  Comparable<Persona> {
	
	    private String nombre;
	    private String apellido;
	    private String dni;
	    
	    public Persona() {
	    	this.nombre = "";
	        this.apellido = "";
	        this.dni = "";
	    }
	    public Persona(String nombre, String apellido, String dni) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.dni = dni;
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}
	    
		
		//Ordena personas alfabéticamente por apellido.
	 
		 @Override
		    public int compareTo(Persona otraPersona) {
		        return this.apellido.compareTo(otraPersona.apellido);
		    }
		 	 
		   
		 //Compara dos personas basándose en el DNI.
		    @Override
		    public boolean equals(Object obj) {
		        if (this == obj) return true;
		        if (obj == null || getClass() != obj.getClass()) return false;
		        Persona persona = (Persona) obj;
		        return dni.equals(persona.dni);
		    }
		    
		    //Genera un código hash basado en el DNI.
		    @Override
		    public int hashCode() {
		        return dni.hashCode();
		    }

		   
		    @Override
		    public String toString() {
		        return "[ " + nombre + " " + apellido + " - DNI: " + dni + " ]";
		    }
		    
		    
		    public boolean VerificarDniInvalido(String Dni) throws DniInvalido
		    {
		    	Boolean tieneLetra = false;
		    	
		    	for(int i=0; i < Dni.length(); i++)
		    	{
		    		char aux = Dni.charAt(i);
		    		
		    		if(!Character.isDigit(aux)) 
		    		{
		    			tieneLetra = true;
		    		}
		    	}
		    	
		    	if(tieneLetra)
		    	{
		    		throw new DniInvalido();
		    	}
		    	
		    	if(tieneLetra)
		    	{
		    		return false;
		    	}
		    	
		    	return true;
		    }
		    
}
