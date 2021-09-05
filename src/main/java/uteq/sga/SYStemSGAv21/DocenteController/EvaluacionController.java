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
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Entity.Evaluaciones;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IDocentesServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;
import uteq.sga.SYStemSGAv21.Services.IEvaluacionesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Evaluacion")
public class EvaluacionController {
    
     @Autowired
    private IEvaluacionesServices evaServ;
    
    @Autowired
    private IDocentesServices doceServ;
    
    @Autowired
    private IAsignaturaServices asignaturaServ;
    
    @Autowired
    private IEstudiantesServices estuServ;
    
 
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Evaluaciones> evalua = evaServ.listarTodos();
        model.addAttribute("evaluacion", evalua);
        return "/Administrator/Evaluacionlist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
      
        List<Asignaturas> asignatura = asignaturaServ.listarTodos();
         List<Docentes> docente = doceServ.listarTodos();
          List<Estudiantes> estudiante = estuServ.listarTodos();
          Evaluaciones evalua = new Evaluaciones();
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("evaluacion", evalua);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("docentes", docente);
        model.addAttribute("estudiantes", estudiante);
        
        return "/Administrator/Evaluacionadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Evaluaciones user){
        evaServ.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Evaluacion/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
         List<Asignaturas> asignatura = asignaturaServ.listarTodos();
         List<Docentes> docente = doceServ.listarTodos();
          List<Estudiantes> estudiante = estuServ.listarTodos();
          Evaluaciones evalua = evaServ.buscaById(id);
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("evaluacion", evalua);
        model.addAttribute("asignaturas", asignatura);
        model.addAttribute("docentes", docente);
        model.addAttribute("estudiantes", estudiante);
        
        return "/Administrator/Evaluacionadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        evaServ.eliminar(id);
        return "redirect:/Admin/Evaluacion/listar";
    }
    
}
