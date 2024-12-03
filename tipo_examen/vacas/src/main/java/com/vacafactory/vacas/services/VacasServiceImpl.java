package com.vacafactory.vacas.services;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vacafactory.vacas.entity.Vacas;

@Service
@Scope("session")
public class VacasServiceImpl implements VacasService {

    private ArrayList<Vacas> vacas = new ArrayList<>();
    private String error = null;

    @Override
    public void editarVaca(Integer id, String nombre, String fechaNac, Double peso) {
        for (Vacas vacas2 : vacas) {
            if (vacas2.getId().equals(id)) {
                vacas2.setNombre(nombre);
                vacas2.setFechaNac(fechaNac);
                vacas2.setPeso(peso);
                error = null;

            } else {
                error = "No se encontró la vaca con el ID especificado.";
            }
        }

    }

    @Override
    public void eliminarVaca(Integer id) {
        Vacas vacaEliminar = null;
        for (Vacas vaca : vacas) {
            if (vaca.getId().equals(id)) {
                vacaEliminar = vaca;
                break;
            }
        }

        if (vacaEliminar != null) {
            vacas.remove(vacaEliminar);
            error = null;
        } else {
            error = "No se encontró la vaca con el ID especificado.";
        }

    }

    @Override
    public void guardarVaca(Integer id, String nombre, String fechaNac, Double peso, MultipartFile file) {
        for (Vacas vaca : vacas) {
            if (vaca.getId().equals(id)) {
                error = "Lo siento, esta vaca ya existe.";
                return;
            }
        }

        Vacas nuevaVaca = new Vacas(id, nombre, fechaNac, peso);
        vacas.add(nuevaVaca);
        error = null;
    }

    @Override
    public ArrayList<Vacas> listarVacas() {
        return vacas;
    }

    public String getError() {
        return error;
    }
}
