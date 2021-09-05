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
import uteq.sga.SYStemSGAv21.Entity.PlanEstudio;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.ICarrerasServices;
import uteq.sga.SYStemSGAv21.Services.IPlanEstudioServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Docente/PlanEstudio")
public class PlanEstudioController {
    
    @Autowired
    private IAsignaturaServices asigServ;
    
    @Autowired
    private ICarrerasServices cursoServ;
    
    @Autowired
    private IPlanEstudioServices planServ;
    
    @RequestMapping("/listar")
    public String page(Model model) {
       
        List<PlanEstudio> plan = planServ.listarTodos();
         model.addAttribute("planestudio", plan);
        return "/Docente/PlanEstudiolist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
      
        List<Asignaturas> asignatura = asigServ.listarTodos();
         List<Carreras> curso = cursoServ.listarTodos();
         
          PlanEstudio plan = new PlanEstudio();
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("planestudio", plan);
        model.addAttribute("asignaturas", asignatura);
    
        
        return "/Docente/Evaluacionadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute PlanEstudio user){
        planServ.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Docente/Evaluacion/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        List<Asignaturas> asignatura = asigServ.listarTodos();
         List<Carreras> curso = cursoServ.listarTodos();
         
          PlanEstudio plan = planServ.buscaById(id);
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("planestudio", plan);
        model.addAttribute("asignaturas", asignatura);
    
        
        return "/Docente/Evaluacionadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        planServ.eliminar(id);
        return "redirect:/Docente/Evaluacion/listar";
    }
    
}
