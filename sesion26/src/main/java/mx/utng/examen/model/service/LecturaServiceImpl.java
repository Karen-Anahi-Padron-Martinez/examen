package mx.utng.examen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.examen.model.dao.ILecturaDao;
import mx.utng.examen.model.entity.Lectura;

@Service
public class LecturaServiceImpl implements ILecturaService{
    //Inyectamos la interfaz para utilizar los métodos de CRUD
     //C-Create, R-Read Retrieve, U-Update, D-Delete
     @Autowired
     private ILecturaDao dao;
 
 
     @Transactional(readOnly = true)
     @Override
     public List<Lectura> list() {
         return dao.list();
     }
 
     @Transactional
     @Override
     public void save(Lectura Lectura) {
         dao.save(Lectura);
     }
 
     @Transactional(readOnly = true)
     @Override
     public Lectura getById(Long id) {
         return dao.getById(id);
     }
 
     @Transactional
     @Override
     public void delete(Long id) {
         dao.delete(id);
     }
     
 }
 
