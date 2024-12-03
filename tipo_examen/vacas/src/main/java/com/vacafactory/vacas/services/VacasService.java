package com.vacafactory.vacas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vacafactory.vacas.entity.Vacas;

@Service
public interface VacasService {
    void guardarVaca(Integer id, String nombre, String fechaNac, Double peso, MultipartFile file);
    void eliminarVaca(Integer id);
    void editarVaca(Integer id, String nombre, String fechaNac, Double peso);
    ArrayList<Vacas> listarVacas();
    String getError();
}
