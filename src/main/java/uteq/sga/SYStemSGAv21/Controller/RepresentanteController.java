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
import uteq.sga.SYStemSGAv21.Entity.Representante;
import uteq.sga.SYStemSGAv21.Services.IRepresentanteServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Representante")
public class RepresentanteController {
    
    @Autowired
    private IRepresentanteServices represerv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Representante> repre= represerv.listarTodos();
        model.addAttribute("titulo", "Nuevo Docente");
        model.addAttribute("representante", repre);
        return "/Administrator/Representantelist";
    }
    @GetMapping("/Create")
    public String crear(Model model){
        Representante repre = new Representante();
        model.addAttribute("titulo", "Lista de Representantes");
        model.addAttribute("representante", repre);
        return "/Administrator/RepresentanteAdd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Representante user){
        represerv.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Representante/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Representante repre = represerv.buscaById(id);
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("representante", repre);
        return "/Administrator/RepresentanteAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        represerv.eliminar(id);
        return "redirect:/Admin/Representante/listar";
    }
}
