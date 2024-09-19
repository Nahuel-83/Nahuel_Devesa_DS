package com.nahuel_proyecto.entity;

import java.util.ArrayList;
import java.util.List;


public class Persona {
    String dni;
    String nombre;
    Integer edad;
    public Persona(String dni, String nombre, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {    
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }
    
    
    public static int obtenerEdadDelMayor(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        int maxEdad = personas.get(0).getEdad();
        for (Persona persona : personas) {
            if (persona.getEdad() > maxEdad) {
                maxEdad = persona.getEdad();
            }
        }
        return maxEdad;
    }
    
    public static double obtenerEdadMedia(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        int suma = 0;
        for (Persona persona : personas) {
            suma += persona.getEdad();
        }
        return (double) suma / personas.size();
    }
    
    public static String obtenerNombreDelMayor(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        Persona mayor = personas.get(0);
        for (Persona persona : personas) {
            if (persona.getEdad() > mayor.getEdad()) {
                mayor = persona;
            }
        }
        return mayor.getNombre();
    }
    
    public static Persona obtenerPersonaMayor(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        Persona mayor = personas.get(0);
        for (Persona persona : personas) {
            if (persona.getEdad() > mayor.getEdad()) {
                mayor = persona;
            }
        }
        return mayor;
    }
    
    public static ArrayList<Persona> obtenerMayoresDeEdad(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        ArrayList<Persona> mayores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() >= 18) {
                mayores.add(persona);
            }
        }
        return mayores;
    }
    
    public static ArrayList<Persona> obtenerPersonasEdadMayorIgualMedia(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas no puede estar vacía");
        }
        double edadMedia = obtenerEdadMedia(personas);
        ArrayList<Persona> mayoresAMedia = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() >= edadMedia) {
                mayoresAMedia.add(persona);
            }
        }
        return mayoresAMedia;
    }
}
    
    

