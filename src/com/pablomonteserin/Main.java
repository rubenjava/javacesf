package com.pablomonteserin;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Escribe el número de DNI: ");
//		String dni = scanner.next();
//		System.out.println("Escribe el nuevo nombre: ");
//		String nombre = scanner.next();
//		System.out.println("Escribe la nueva edad: ");
//		int edad = scanner.nextInt();

		Servicio servicio = new Servicio();
		servicio.consultarPersonas();
		List<Persona> personas = servicio.consultarPersonas();
		Iterator<Persona> it = personas.iterator();
		while (it.hasNext()) {
			Persona p = it.next();
		System.out.println("DNI: " + p.getDni() +" Nombre: " + p.getNombre() + " Edad " + p.getEdad());
		}

	}

}//gkghkyhkh

