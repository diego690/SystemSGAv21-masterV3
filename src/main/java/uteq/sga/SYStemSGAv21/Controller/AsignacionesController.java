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
import uteq.sga.SYStemSGAv21.Entity.Asignaciones;
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.Aula;
import uteq.sga.SYStemSGAv21.Entity.Carreras;
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.Secciones;
import uteq.sga.SYStemSGAv21.Services.IAsignacionesServices;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IAulaServices;
import uteq.sga.SYStemSGAv21.Services.ICarrerasServices;
import uteq.sga.SYStemSGAv21.Services.IDocentesServices;
import uteq.sga.SYStemSGAv21.Services.ISeccionesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Asignaciones")
public class AsignacionesController {
    
    @Autowired
    private IAsignacionesServices asigServ;
    
    @Autowired
    private IDocentesServices doceServ;
    
    @Autowired
    private IAsignaturaServices asignaturaServ;
    
    @Autowired
    private IAulaServices aulaServ;
    
    @Autowired
    private ISeccionesServices seccServ;
    
    @Autowired
    private ICarrerasServices carreraServ;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Asignaciones> asignacion = asigServ.listarTodos();
        model.addAttribute("asignaciones", asignacion);
        return "/Administrator/Asignacioneslist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
        List<Docentes> docente = doceServ.listarTodos();
        List<Asignaturas> asignatura = asignaturaServ.listarTodos();
         List<Aula> aulas = aulaServ.listarTodos();
          List<Secciones> seccion = seccServ.listarTodos();
           List<Carreras> curso = carreraServ.listarTodos();
        Asignaciones document = new Asignaciones();
        model.addAttribute("titulo", "Lista de Docentes");
        model.addAttribute("docente", docente);
        model.addAttribute("asignacion", document);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("aula", aulas);
        model.addAttribute("secciones", seccion);
        model.addAttribute("cursos", curso);
        return "/Administrator/Asignacionesadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Asignaciones user){
        asigServ.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Asignaciones/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Asignaciones document = asigServ.buscaById(id);
         List<Docentes> docente = doceServ.listarTodos();
        List<Asignaturas> asignatura = asignaturaServ.listarTodos();
         List<Aula> aulas = aulaServ.listarTodos();
          List<Secciones> seccion = seccServ.listarTodos();
           List<Carreras> curso = carreraServ.listarTodos();
        model.addAttribute("docente", docente);
        model.addAttribute("asignacion", document);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("aula", aulas);
        model.addAttribute("secciones", seccion);
        model.addAttribute("cursos", curso);
        return "/Administrator/Asignacionesadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        asigServ.eliminar(id);
        return "redirect:/Admin/Asignaciones/listar";
    }
    
}
