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
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.Horarioclase;
import uteq.sga.SYStemSGAv21.Entity.Horarios;
import uteq.sga.SYStemSGAv21.Entity.Time;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IHorarioClaseServices;
import uteq.sga.SYStemSGAv21.Services.IHorariosServices;
import uteq.sga.SYStemSGAv21.Services.ITimeServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Horario")
public class HorarioController {
    
    @Autowired
    private IAsignaturaServices asigServ;
    
    @Autowired
    private IHorariosServices horaServ;
    
    @Autowired
    private IHorarioClaseServices horarioCServ;
    
    @Autowired
    private ITimeServices timeServ;
    
    @RequestMapping("/horario")
    public String page(Model model) {
        List<Horarioclase> horarioClase = horarioCServ.listarTodos();
        model.addAttribute("hclase", horarioClase);
        List<Horarios> horas = horaServ.listarTodos();
        List<Asignaturas> asignaturas= asigServ.listarTodos();
        List<Time> time = timeServ.listarTodos();
        model.addAttribute("times", time);
        model.addAttribute("hora", horas);
        model.addAttribute("asignatura", asignaturas);
        return "/Administrator/Horario2";
    }
    
}
