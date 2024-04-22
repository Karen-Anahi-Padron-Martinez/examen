package mx.utng.examen.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.examen.model.entity.Presupuesto;

@Repository
public class PresupuestoDaoImpl implements IPresupuestoDao{
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Presupuesto> list() {
        return em.createQuery("from Presupuesto").getResultList();
    }

    @Override
    public void save(Presupuesto presupuesto) {
        if(presupuesto.getId() != null && presupuesto.getId() >0){
            em.merge(presupuesto);
        }else{
            em.persist(presupuesto);
        }
    }

    @Override
    public Presupuesto getById(Long id) {
        return em.find(Presupuesto.class, id);
    }

    @Override
    public void delete(Long id) {
        Presupuesto presupuesto = getById(id);
        em.remove(presupuesto);
    }

}

