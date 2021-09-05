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
import uteq.sga.SYStemSGAv21.Entity.YearsAcademicos;
import uteq.sga.SYStemSGAv21.Services.IYearsAcademicosServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Years")
public class YearsAcademicosController {
    
    @Autowired
    private IYearsAcademicosServices yaserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<YearsAcademicos> yacademic = yaserv.listarTodos();
        model.addAttribute("titulo", "Listado de Periodos Academicoas Vigentes");
        model.addAttribute("yacademico", yacademic);
        return "/Administrator/YearAcademicolist";
    }
    @RequestMapping("/Create")
    public String crear(Model model){
        YearsAcademicos yacademic = new YearsAcademicos();
        model.addAttribute("titulo", "Edicion de Periodo Academico");
        model.addAttribute("yacademico", yacademic);
        return "/Administrator/YearsAcademicoAdd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute YearsAcademicos user){
        
        yaserv.guardar(user);
        System.out.println("Registro guardado correctamente");
        return "redirect:/Admin/Years/listar";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        YearsAcademicos yacademic = yaserv.buscaById(id);
        model.addAttribute("titulo", "Edicion de Periodo Academico");
        model.addAttribute("yacademico", yacademic);
        return "/Administrator/YearsAcademicoAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        yaserv.eliminar(id);
         return "redirect:/Admin/Years/listar";
    }
    
}
