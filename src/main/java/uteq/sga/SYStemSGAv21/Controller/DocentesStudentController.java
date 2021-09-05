/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.Docentes;

import uteq.sga.SYStemSGAv21.Services.IDocentesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Stud/Docentes")
public class DocentesStudentController {
    
    @Autowired
    private IDocentesServices docenServi;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Docentes> docent= docenServi.listarTodos();
        model.addAttribute("titulo", "Nuevo Docente");
        model.addAttribute("docente", docent);
        return "/Student/Docenteslist";
    }
    @GetMapping("/Create")
    public String crear(Model model){
        Docentes document = new Docentes();
        model.addAttribute("titulo", "Lista de Docentes");
        model.addAttribute("docente", document);
        return "/Student/DocentesAdd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Docentes user){
        docenServi.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Stud/Docentes/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Docentes document = docenServi.buscaById(id);
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("docente", document);
        return "/Student/DocentesAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        docenServi.eliminar(id);
        return "redirect:/Stud/Docentes/listar";
    }
    
}
