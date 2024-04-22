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
import mx.utng.examen.model.entity.Lectura;
import mx.utng.examen.model.service.ILecturaService;



@Controller
@SessionAttributes("lectura")
public class LecturaController {
    @Autowired
    private ILecturaService service;

    @GetMapping({"/lectura", "/lectura/", "/lectura/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Lecturaes");
        model.addAttribute("lecturaes", service.list());
        return "lectura-list";
    }

    @GetMapping("/lectura/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Lecturaes");
        model.addAttribute("lectura", new Lectura());
        return "lectura-form";
    }

    @PostMapping("/lectura/form")
    public String save(@Valid Lectura lectura, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Lecturas");
            return "lectura-form";
        }
        service.save(lectura);
        return "redirect:/lectura/list";
    }

    @GetMapping("/lectura/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Lectura lectura = null;
        if(id>0){
            lectura = service.getById(id);
        }else{
            return "redirect:/lectura/list";
        }
        model.addAttribute("title", "Editar Lectura");
        model.addAttribute("lectura", lectura);
        return "lectura-form";
    }

   
    @GetMapping("/lectura/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/lectura/list";
    }

}