package mx.utng.examen.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.examen.model.entity.ListaEspera;


/*
* Clase repositorio o Dao permite guardar datos y estar trabajando con ellos
UTILIZARE LA ANOTACIÓN @Repositorio
Repositorios: Sirven para guardar info(CLASES,METODOS,ETC)
 */

 @Repository
public class ListaEsperaDaoImpl implements IListaEsperaDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<ListaEspera> list() {
        return em.createQuery("from ListaEspera").getResultList();
        
    }

    @Override
    public void save(ListaEspera listaEspera) {
        if(listaEspera.getId()!=null && listaEspera.getId()>0){
     
            em.merge(listaEspera);
        }else{
            
            em.persist(listaEspera);
        }
        
    }

    @Override
    public ListaEspera getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(ListaEspera.class, id);        
    }

    @Override
    public void delete(Long id) {
    ListaEspera listaEspera = getById(id); 
    em.remove(listaEspera);
    }
    
}
