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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.Secciones;
import uteq.sga.SYStemSGAv21.Entity.YearsAcademicos;
import uteq.sga.SYStemSGAv21.Services.ISeccionesServices;
import uteq.sga.SYStemSGAv21.Services.IYearsAcademicosServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Secciones")
public class SeccionesController {
    
    @Autowired
    private ISeccionesServices secserv;
    
    @Autowired
    private IYearsAcademicosServices yacadeserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Secciones> secciones= secserv.listarTodos();
        model.addAttribute("titulo", "Lista de Secciones Escolares");
        model.addAttribute("seccion", secciones);
        return "/Administrator/Seccioneslist";
    }
    @RequestMapping("create")
    public String crear(Model model){
        Secciones secciones = new Secciones();
        List<YearsAcademicos> yacad = yacadeserv.listarTodos();
        model.addAttribute(("titulo"), "Crear Nueva Seccion");
        model.addAttribute("secciones", secciones);
        model.addAttribute("yacademico", yacad);
        return "/Administrator/SeccionesAdd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Secciones user){
        secserv.guardar(user);
        System.out.println("Registro exitosamente guardado");
        return "redirect:/Admin/Secciones/listar";
    }
    @RequestMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Secciones secciones = secserv.buscaById(id);
        List<YearsAcademicos> yacad = yacadeserv.listarTodos();
        model.addAttribute(("titulo"), "Crear Nueva Seccion");
        model.addAttribute("secciones", secciones);
        model.addAttribute("yacademico", yacad);
        return "/Administrator/SeccionesAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        secserv.eliminar(id);
        return "redirect:/Admin/Secciones/listar";
    }
    
}
