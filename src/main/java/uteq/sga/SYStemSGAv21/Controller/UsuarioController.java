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
import uteq.sga.SYStemSGAv21.Entity.Usuarios;
import uteq.sga.SYStemSGAv21.Services.INivelesServices;
import uteq.sga.SYStemSGAv21.Services.IUsuariosServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Usuarios")
public class UsuarioController {
    
    @Autowired
    private IUsuariosServices userserv;
    
    @Autowired
    private INivelesServices nivelserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Usuarios> user = userserv.listarTodos();
        model.addAttribute("titulo", "Lista de Usuarios");
        model.addAttribute("usuarios", user);
        return "/Administrator/Usuarioslist";
    }
    @GetMapping("/Create")
    public String crear(Model model){
        Usuarios user = new Usuarios();
        List<Niveles> niv = nivelserv.listarTodos();
        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("nivel", niv);
        model.addAttribute("usuario", user);
        return "/Administrator/UsuariosAdd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Usuarios user){
        userserv.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Usuarios/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Usuarios user = userserv.buscaById(id);
         List<Niveles> niv = nivelserv.listarTodos();
        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("nivel", niv);
        model.addAttribute("usuario", user);
        return "/Administrator/UsuariosAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        userserv.eliminar(id);
        return "redirect:/Admin/Usuarios/listar";
    }
    
}
