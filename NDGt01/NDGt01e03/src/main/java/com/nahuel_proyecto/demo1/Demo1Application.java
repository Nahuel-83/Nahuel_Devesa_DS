package com.nahuel_proyecto.demo1;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nahuel_proyecto.entity.Persona;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
                
                final ArrayList<Persona> personas = new ArrayList<>();
                personas.add(new Persona("12345678A", "Ana", 25));
                personas.add(new Persona("87654321B", "Luis", 30));
                personas.add(new Persona("23456789C", "Marta", 20));
                personas.add(new Persona("34567890D", "Carlos", 40));
                personas.add(new Persona("45678901E", "Julia", 35));
                personas.add(new Persona("56789012F", "Pedro", 50));
                System.out.println("\n\n");
          

                System.out.println("\nEdad del mayor: " + Persona.obtenerEdadDelMayor(personas));
                System.out.println("\nEdad media: " + Persona.obtenerEdadMedia(personas));
                System.out.println("\nNombre del mayor: " + Persona.obtenerNombreDelMayor(personas));
                
                Persona personaMayor = Persona.obtenerPersonaMayor(personas);
                System.out.println("\nLa persona mas mayor es: " + personaMayor.toString());

                ArrayList<Persona> personasMayoresEdad = Persona.obtenerMayoresDeEdad(personas);
                System.out.println("\nLas personas mayores de edad:");
                for (Persona persona : personasMayoresEdad) {
                    System.out.println(persona.getNombre() + " - Edad: " + persona.getEdad());
                }

                ArrayList<Persona> personasEdadMayorIgualMedia = Persona.obtenerPersonasEdadMayorIgualMedia(personas);
                
                System.out.println("\nPersonas con edad mayor o igual a la media:");
                
                for (Persona persona : personasEdadMayorIgualMedia) {
                        System.out.println(persona.getNombre() + " - Edad: " + persona.getEdad());
                }
        }
}
