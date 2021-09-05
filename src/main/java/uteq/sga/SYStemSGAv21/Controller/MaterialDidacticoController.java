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
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.MaterialDidactico;
import uteq.sga.SYStemSGAv21.Services.IDocentesServices;
import uteq.sga.SYStemSGAv21.Services.IMaterialDidacticoServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Material.Didactico")
public class MaterialDidacticoController {
    
    @Autowired
    private IMaterialDidacticoServices materialServ;
    
    @Autowired
    private IDocentesServices doceServ;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<MaterialDidactico> materialD = materialServ.listarTodos();
        model.addAttribute("material", materialD);
        return "/Administrator/MaterialDidacticolist";
    }
     @GetMapping("/Create")
    public String crear(Model model){
      
        MaterialDidactico materialD = new MaterialDidactico();
         List<Docentes> docente = doceServ.listarTodos();
          
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("material", materialD);
        model.addAttribute("docentes", docente);
       
        
        return "/Administrator/MaterialDidacticoadd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute MaterialDidactico user){
        materialServ.guardar(user);
        System.out.println("Registro registrado correctamente");
        return "redirect:/Admin/Material.Didactico/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
       MaterialDidactico materialD = materialServ.buscaById(id);
         List<Docentes> docente = doceServ.listarTodos();
          
        model.addAttribute("titulo", "Lista de Docentes");
     
        model.addAttribute("material", materialD);
        model.addAttribute("docentes", docente);
       
        
        return "/Administrator/MaterialDidacticoadd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        materialServ.eliminar(id);
        return "redirect:/Admin/Material.Didactico/listar";
    }
    
}
