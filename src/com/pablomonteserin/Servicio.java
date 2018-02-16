package com.pablomonteserin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Servicio {
	
	void insertarRegistro(String dni, String nombre, int edad) {
		
		
		Connection databaseConnection =  getConnection(); 
			
			try {
				Statement statement2;
				statement2 = databaseConnection.createStatement();
				statement2.executeUpdate("INSERT INTO prueba (dni,nombre,edad)values('" + dni + "', '" + nombre + "'," + edad + ")");
				statement2.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}		
	
	List<Persona> consultarPersonas(){
		Connection conet = getConnection();
		
		List<Persona> personas = new ArrayList<Persona>();
		try {
			
			Statement statement;
			statement = conet.createStatement();
			ResultSet personasrs = statement.executeQuery("SELECT * FROM prueba");
			
			while (personasrs.next()){
				Persona p = new Persona();
				String nombre = personasrs.getString("nombre");
				String dni = personasrs.getString("dni");
				int edad = personasrs.getInt("edad");
				//System.out.println(nombre);
				p.setDni(dni);
				p.setNombre(nombre);
				p.setEdad(edad);
				personas.add(p);
				
				//setNombre(personasrs.getString("nombre"));
				//rsonas.add(personasrs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return personas;
		
	}
        void eliminarRegistro(String dni){
        	Connection conet = getConnection();
        	
			try {
				Statement statement2;
				statement2 = conet.createStatement();
				statement2.executeUpdate("DELETE FROM prueba WHERE dni='"+ dni +"'");
				statement2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
        
		
			 void modificarRegistro(String dni, String nombre, int edad){
		        	Connection conet = getConnection();
		        	
					try {
						Statement statement2;
						statement2 = conet.createStatement();
						statement2.executeUpdate("UPDATE prueba SET nombre = '"+nombre+"', edad = '"+edad+"' WHERE dni='"+dni+"'" );
						statement2.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}

	Connection getConnection() {

		Connection databaseConnection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Define the data source for the driver
			String sourceURL = "jdbc:mysql://localhost/personas";
			// Create a connection through the DriverManager
			databaseConnection = DriverManager.getConnection(sourceURL, "root", "");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return databaseConnection;

	}
	
	
}


