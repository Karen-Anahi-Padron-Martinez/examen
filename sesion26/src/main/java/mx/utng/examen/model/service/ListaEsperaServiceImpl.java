package mx.utng.examen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.examen.model.dao.IListaEsperaDao;
import mx.utng.examen.model.entity.ListaEspera;
/*
 * Una clase service, esta basada aen el patrón de diseño fachada 
 * Es un único punto de acceso hacia los DAO(Date access object).Dentro de la clase service, podemos operar
 * con distintas clases DAO.  
 */
@Service
public class ListaEsperaServiceImpl implements IListaEsperaService {
    //Inyectamos la interfaz para utilizar los métodos de CRUD. 
    //C-Create, R-Read Retrieve, U-Update,D-Delete. 
    @Autowired
    private IListaEsperaDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<ListaEspera> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaEspera listaEspera) {
        dao.save(listaEspera);
    }

    @Transactional(readOnly =  true)
    @Override
    public ListaEspera getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    
}
