package mx.utng.examen.model.dao;
import java.util.List;

import mx.utng.examen.model.entity.ListaEspera;


public interface IListaEsperaDao {
    List<ListaEspera>list(); 
    void save(ListaEspera listaEspera);
    ListaEspera getById(Long id);
    void delete (Long id);

}
