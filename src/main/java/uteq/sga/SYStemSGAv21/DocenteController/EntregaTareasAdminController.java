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
import uteq.sga.SYStemSGAv21.Entity.EntregaTareas;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IEntregaTareasServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Docente/EntregaTareas")
public class EntregaTareasAdminController {
    @Autowired
    private IEntregaTareasServices ent_tar_Serv;
    
    @Autowired
    private IEstudiantesServices estuserv;
    
    @Autowired IAsignaturaServices asigServ;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        model.addAttribute("titulo", "Lista de Tareas");
        List<EntregaTareas> entregaT = ent_tar_Serv.listarTodos();
        model.addAttribute("entregaT", entregaT);
        return "/Docente/EntregaTareaslist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
        EntregaTareas document = new EntregaTareas();
        model.addAttribute("estudiante", estuserv.listarTodos());
        model.addAttribute("asigantura", asigServ.listarTodos());
        model.addAttribute("titulo", "Lista de Docentes");
        model.addAttribute("entregaT", document);
        return "/Docente/EntregaTareasadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute EntregaTareas user){
        ent_tar_Serv.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Docentes/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        EntregaTareas document = ent_tar_Serv.buscaById(id);
         model.addAttribute("estudiante", estuserv.listarTodos());
        model.addAttribute("asigantura", asigServ.listarTodos());
        model.addAttribute("titulo", "Lista de Docentes");
        model.addAttribute("entregaT", document);
        return "/Docente/EntregaTareasadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        ent_tar_Serv.eliminar(id);
        return "redirect:/Docente/Docentes/listar";
    }
}
