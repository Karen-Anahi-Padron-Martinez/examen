package mx.utng.examen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.examen.model.dao.IPresupuestoDao;
import mx.utng.examen.model.entity.Presupuesto;

@Service
public class PresupuestoServiceImpl implements IPresupuestoService{
    //Inyectamos la interfaz para utilizar los métodos de CRUD
     //C-Create, R-Read Retrieve, U-Update, D-Delete
     @Autowired
     private IPresupuestoDao dao;
 
 
     @Transactional(readOnly = true)
     @Override
     public List<Presupuesto> list() {
         return dao.list();
     }
 
     @Transactional
     @Override
     public void save(Presupuesto presupuesto) {
         dao.save(presupuesto);
     }
 
     @Transactional(readOnly = true)
     @Override
     public Presupuesto getById(Long id) {
         return dao.getById(id);
     }
 
     @Transactional
     @Override
     public void delete(Long id) {
         dao.delete(id);
     }
     
 }
 
