/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.DocenteController;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.Carreras;
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.PlanificacionTareas;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.ICarrerasServices;
import uteq.sga.SYStemSGAv21.Services.IDocentesServices;
import uteq.sga.SYStemSGAv21.Services.IPlanificacionTareasServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Docente/PlanificacionTarea")
public class PlanificacionTareaDoceController {
    
    @Autowired
    private IPlanificacionTareasServices ipts;
    
    @Autowired
    private ICarrerasServices carrerasServices;
    
    @Autowired
    private IDocentesServices docentesServices;
    
    @Autowired
    private IAsignaturaServices asignaturaServices;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<PlanificacionTareas> pt = ipts.listarTodos();
        model.addAttribute("planificacionT", pt);
        return "/Docente/PlanificacionTareaslist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
      
        List<Asignaturas> asignatura = asignaturaServices.listarTodos();
         List<Docentes> docente = docentesServices.listarTodos();
         List<Carreras> carrerases = carrerasServices.listarTodos();
          PlanificacionTareas pt = new PlanificacionTareas();
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("planificacionT", pt);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("docentes", docente);
       model.addAttribute("cursos", carrerases);
        
        return "/Docente/PlanificacionTareasadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute PlanificacionTareas user){
        ipts.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Docente/PlanificacionTarea/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
         List<Asignaturas> asignatura = asignaturaServices.listarTodos();
         List<Docentes> docente = docentesServices.listarTodos();
         List<Carreras> carrerases = carrerasServices.listarTodos();
          PlanificacionTareas pt = ipts.buscaById(id);
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("planificacionT", pt);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("docentes", docente);
       model.addAttribute("cursos", carrerases);
        
        return "/Docente/PlanficacionTareasadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        ipts.eliminar(id);
        return "redirect:/Docente/PlanificacionTarea/listar";
    }
}
