package mx.utng.examen.model.service;

import java.util.List;

import mx.utng.examen.model.entity.Presupuesto;

public interface IPresupuestoService {
    List<Presupuesto> list();
    void save(Presupuesto presupuesto);
    Presupuesto getById(Long id);
    void delete(Long id);
}