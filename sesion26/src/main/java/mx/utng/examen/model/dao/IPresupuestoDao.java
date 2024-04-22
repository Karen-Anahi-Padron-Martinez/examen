package mx.utng.examen.model.dao;

import java.util.List;

import mx.utng.examen.model.entity.Presupuesto;

public interface IPresupuestoDao {
    List<Presupuesto> list();
    void save(Presupuesto presupuesto);
    Presupuesto getById(Long id);
    void delete(Long id);
    
} 