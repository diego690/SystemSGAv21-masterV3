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
import uteq.sga.SYStemSGAv21.Entity.Aula;
import uteq.sga.SYStemSGAv21.Entity.Carreras;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Entity.Matriculacion;
import uteq.sga.SYStemSGAv21.Entity.YearsAcademicos;
import uteq.sga.SYStemSGAv21.Services.IAulaServices;
import uteq.sga.SYStemSGAv21.Services.ICarrerasServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;
import uteq.sga.SYStemSGAv21.Services.IMatriculacionServices;
import uteq.sga.SYStemSGAv21.Services.IYearsAcademicosServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Matriculacion")
public class MatriculacionAdminController {
    
   @Autowired
    private IMatriculacionServices matriserv;
    
    @Autowired
    private IEstudiantesServices estuserv;
    
    @Autowired
    private ICarrerasServices carreserv;
    
    @Autowired
    private IYearsAcademicosServices yearserv;
    
    @Autowired
    private IAulaServices aulaserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Matriculacion> matricula = matriserv.listarTodos();
        model.addAttribute("titulo", "Lista de Matriculados");
        model.addAttribute("matriculas", matricula);
        return "/Administrator/Matriculacionlist";
    }
    @RequestMapping("/Create")
    private String crear(Model model){
        Matriculacion matricula = new Matriculacion();
        List<Estudiantes> estudiante = estuserv.listarTodos();
        List<Carreras> carreras = carreserv.listarTodos();
        List<YearsAcademicos> year = yearserv.listarTodos();
        List<Aula> aula = aulaserv.listarTodos();
        model.addAttribute("titulo", "Matriculacion de Estudiante");
        model.addAttribute("matriculas", matricula);
        model.addAttribute("estudiantes", estudiante);
        model.addAttribute("cursos", carreras);
        model.addAttribute("years", year);
        model.addAttribute("aulas", aula);
        return "/Administrator/MatriculacionAdd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Matriculacion user){
        matriserv.guardar(user);
        System.out.println("Registro guardado exitosamente");
        return "redirect:/Admin/Matriculacion/listar";
    }
    @RequestMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Matriculacion matricula = new Matriculacion();
        List<Estudiantes> estudiante = estuserv.listarTodos();
        List<Carreras> carreras = carreserv.listarTodos();
        List<YearsAcademicos> year = yearserv.listarTodos();
        List<Aula> aula = aulaserv.listarTodos();
        model.addAttribute("titulo", "Matriculacion de Estudiante");
        model.addAttribute("matriculas", matricula);
        model.addAttribute("estudiantes", estudiante);
        model.addAttribute("curso", carreras);
        model.addAttribute("years", year);
        model.addAttribute("aulas", aula);
        return "/Administrator/MatriculacionAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        matriserv.eliminar(id);
        return "redirect:/Admin/Matriculacion/listar";
    }
    
}
