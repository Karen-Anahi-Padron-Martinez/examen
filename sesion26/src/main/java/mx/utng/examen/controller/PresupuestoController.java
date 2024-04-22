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
import mx.utng.examen.model.entity.Presupuesto;
import mx.utng.examen.model.service.IPresupuestoService;

@Controller
@SessionAttributes("presupuesto")
public class PresupuestoController {
    @Autowired
    private IPresupuestoService service;

    @GetMapping({"/presupuesto", "/presupuesto/", "/presupuesto/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de presupuestos");
        model.addAttribute("presupuestos", service.list());
        return "presupuesto-list";
    }

    @GetMapping("/presupuesto/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de presupuestos");
        model.addAttribute("presupuesto", new Presupuesto());
        return "presupuesto-form";
    }

    @PostMapping("/presupuesto/form")
    public String save(@Valid Presupuesto presupuesto, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Presupuestos");
            return "presupuesto-form";
        }
        service.save(presupuesto);
        return "redirect:/presupuesto/list";
    }

    @GetMapping("/presupuesto/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Presupuesto presupuesto = null;
        if(id>0){
            presupuesto = service.getById(id);
        }else{
            return "redirect:/presupuesto/list";
        }
        model.addAttribute("title", "Editar Presupuesto");
        model.addAttribute("presupuesto", presupuesto);
        return "presupuesto-form";
    }

    @GetMapping("/presupuesto/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/presupuesto/list";
    }

}


