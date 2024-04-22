package mx.utng.examen.model.service;

import java.util.List;

import mx.utng.examen.model.entity.ListaEspera;

public interface IListaEsperaService {
    List<ListaEspera> list();
    void save (ListaEspera listaEspera); 
    ListaEspera getById(Long id); 
    void delete (Long id);
}
