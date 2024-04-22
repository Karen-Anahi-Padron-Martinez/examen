package mx.utng.examen.model.dao;

import java.util.List;

import mx.utng.examen.model.entity.Lectura;

public interface ILecturaDao {
    List<Lectura> list();
    void save(Lectura lectura);
    Lectura getById(Long id);
    void delete(Long id);
    
} 