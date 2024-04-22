package mx.utng.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.examen.model.entity.ListaEspera;
import mx.utng.examen.model.service.IListaEsperaService;

@Controller
@SessionAttributes("listaEspera")
public class ListaEsperaController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IListaEsperaService service;


    @GetMapping({"","/","/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado de ListaEspera");
    model.addAttribute("listaEsperas",service.list());
    return "list";

    }

    @GetMapping("/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 
    public String create(Model model){
        model.addAttribute("title","Formulario ListaEspera ");
        model.addAttribute("listaEspera", new ListaEspera());
        return "form";
    }

    @PostMapping("/form")  
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid ListaEspera listaEspera,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de ListaEspera Ventas");
            return "form";
        }
        service.save(listaEspera);
        return "redirect:list";

    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaEspera listaEspera = null;
        if(id>0){
            listaEspera = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar ListaEspera Ventas");
        model.addAttribute("listaEspera", listaEspera);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
