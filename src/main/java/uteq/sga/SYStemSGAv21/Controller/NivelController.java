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
import uteq.sga.SYStemSGAv21.Entity.Niveles;
import uteq.sga.SYStemSGAv21.Services.INivelesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Niveles")
public class NivelController {
    
    @GetMapping("/Dashboard")
    public String Das(Model model){
        model.addAttribute("title", "DashBoard Administrador - SGAA");
        return "/Administrator/index";
    }
    
    @Autowired
    private INivelesServices nivelserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Niveles> nivelist=nivelserv.listarTodos();
        int n = nivelserv.total();
        model.addAttribute("Titulo", "Lista Niveles Usuarios");
        model.addAttribute("total", n);
        model.addAttribute("Niveles", "Niveles");
        model.addAttribute("niveles", nivelist);
        return "/Administrator/NivelListar";
    }
    @GetMapping("/Create")
    public String crea(Model model){
        Niveles nivelu= new Niveles();
        model.addAttribute("titulo", "Nuevo Nivel de Usuario");
        model.addAttribute("nivel", nivelu);
        return "/Administrator/NivelAdd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Niveles user){
        nivelserv.guardar(user);
        System.out.println("Registro Registrado Correctamente");
        return "redirect:/Admin/Niveles/listar";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Niveles nv = nivelserv.buscaById(id);
        model.addAttribute("titulo", "Editar Nivel de Usuario");
        model.addAttribute("nivel", nv);
        return "/Administrator/NivelAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        nivelserv.eliminar(id);
        return "redirect:/Admin/Niveles/listar";
    }
    
}
