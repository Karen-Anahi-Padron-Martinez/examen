package mx.utng.examen.model.service;

import java.util.List;

import mx.utng.examen.model.entity.Lectura;

public interface ILecturaService {
    List<Lectura> list();
    void save(Lectura lectura);
    Lectura getById(Long id);
    void delete(Long id);
}