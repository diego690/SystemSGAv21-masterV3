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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.EntregaTareas;
import uteq.sga.SYStemSGAv21.Entity.Notastareas;
import uteq.sga.SYStemSGAv21.Services.IEntregaTareasServices;
import uteq.sga.SYStemSGAv21.Services.INotasTareasServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Repre/NotasTareas")
public class NotasTareaController {
    
    @Autowired
    private INotasTareasServices notaserv;
    
    @Autowired
    private IEntregaTareasServices entregaTserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        model.addAttribute("titulo", "Listado de Notas de Tareas");
        List<Notastareas> notasT = notaserv.listarTodos();
        model.addAttribute("notasTareas", entregaTserv);
        return "/Representante/NotaTareaslist";
    }
    @RequestMapping("/Create")
    public String crear(Model model){
        model.addAttribute("titulo", "Nuevo Ingreso de Notas");
        Notastareas notasT = new Notastareas();
        List<EntregaTareas> entregTarea = entregaTserv.listarTodos();
        model.addAttribute("entregaTareas", entregTarea);
        model.addAttribute("notasTarea", notasT);
        return "/Representante/NotasTareasAdd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Notastareas user){
        notaserv.guardar(user);
        System.out.println("Notas registradas correctamente");
        return "redirect:/Repre/NotasTareas/listar";
    }
    @RequestMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("titulo", "Edicion Ingreso de Notas");
        Notastareas notasT = notaserv.buscaById(id);
        List<EntregaTareas> entregTarea = entregaTserv.listarTodos();
        model.addAttribute("entregaTareas", entregTarea);
        model.addAttribute("notasTarea", notasT);
        return "/Representante/NotasTareasAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        notaserv.eliminar(id);
        System.out.println("Notas eliminada correctamente");
        return "redirect:/Repre/NotasTareas/listar";
    }
    
}
