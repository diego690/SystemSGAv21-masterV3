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
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.SYStemSGAv21.Entity.EntregaTareas;
import uteq.sga.SYStemSGAv21.Services.IEntregaTareasServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Repre/EntregaTareas")
public class EntregaTareasController {
    @Autowired
    private IEntregaTareasServices ent_tar_rep;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        model.addAttribute("titulo", "Lista de Tareas");
        List<EntregaTareas> entregaT = ent_tar_rep.listarTodos();
        model.addAttribute("entregaT", entregaT);
        return "/Representante/EntregaTareaslist";
    }
    
}
