package mx.utng.examen.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.examen.model.entity.Lectura;

@Repository
public class LecturaDaoImpl implements ILecturaDao{
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Lectura> list() {
        return em.createQuery("from Lectura").getResultList();
    }

    @Override
    public void save(Lectura lectura) {
        if(lectura.getId() != null && lectura.getId() >0){
            em.merge(lectura);
        }else{
            em.persist(lectura);
        }
    }

    @Override
    public Lectura getById(Long id) {
        return em.find(Lectura.class, id);
    }

    @Override
    public void delete(Long id) {
        Lectura lectura = getById(id);
        em.remove(lectura);
    }

}

