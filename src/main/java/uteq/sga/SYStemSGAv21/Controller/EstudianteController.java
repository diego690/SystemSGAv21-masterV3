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
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Entity.Representante;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;
import uteq.sga.SYStemSGAv21.Services.IRepresentanteServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Estudiante")
public class EstudianteController {
    
    @Autowired
    private IEstudiantesServices estuserv;
    
    @Autowired
    private IRepresentanteServices represerv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Estudiantes> estu= estuserv.listarTodos();
        model.addAttribute("titulo", "Listado de Estudiantes");
        model.addAttribute("estudiante", estu);
        return "/Administrator/Estudiantelist";
    }
    @RequestMapping("/Create")
    public String crear(Model model){
        Estudiantes estudiante = new Estudiantes();
        List<Representante> repre = represerv.listarTodos();
        model.addAttribute(("titulo"), "Nuevo Estudiante");
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("representante", repre);
        return "/Administrator/EstudianteAdd";
    }
    @RequestMapping("/save")
    public String guarda(@ModelAttribute Estudiantes user){
        estuserv.guardar(user);
        System.out.println("Registrado correctamente");
        return "redirect:/Admin/Estudiante/listar";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Estudiantes estudiante = estuserv.buscaById(id);
        List<Representante> repre = represerv.listarTodos();
        model.addAttribute(("titulo"), "Nuevo Estudiante");
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("representante", repre);
        return "/Administrator/EstudianteAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delele(@PathVariable("id") Integer id,Model model){
        estuserv.eliminar(id);
         return "redirect:/Admin/Estudiante/listar";
    }
    
}
