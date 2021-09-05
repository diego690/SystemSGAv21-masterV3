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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.EntregaTareas;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Services.IEntregaTareasServices;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Stud/EntregaTareas")
public class EntregaTareasStudentController {
    @Autowired
    private IEntregaTareasServices ent_tar_rep;
    
    @Autowired
    private IAsignaturaServices ent_tra_asig;
    
    @Autowired
    private IEstudiantesServices ent_tra_est;
    
    
    @RequestMapping("/listar")
    public String page(Model model) {
        model.addAttribute("titulo", "Lista de Tareas");
        List<EntregaTareas> entregaT = ent_tar_rep.listarTodos();
        model.addAttribute("entregaT", entregaT);
        return "/Student/EntregaTareaslist";
    }
    @GetMapping("/Create")
    public String crear(Model model){
        EntregaTareas tareasds = new EntregaTareas();
        List<Estudiantes> estud=ent_tra_est.listarTodos();
        List<Asignaturas> asig=ent_tra_asig.listarTodos();
        model.addAttribute("titulo", "Lista de Tareas");
        model.addAttribute("tareasd", tareasds);
        model.addAttribute("estud",estud);
        model.addAttribute("asig",asig);
        return "/Student/EntregaTareasadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute EntregaTareas user){
        ent_tar_rep.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Stud/Docentes/listar";
    }
}
