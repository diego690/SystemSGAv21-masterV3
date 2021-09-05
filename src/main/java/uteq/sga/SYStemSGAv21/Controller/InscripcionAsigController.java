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

import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Entity.InscripcionesAsignaturas;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;
import uteq.sga.SYStemSGAv21.Services.IInscripcionAsignaturasServices;

@Controller
@RequestMapping("/Admin/Inscripciones")
public class InscripcionAsigController {
	
	@Autowired
	private IInscripcionAsignaturasServices inscripServ;
	
	@Autowired
	private IAsignaturaServices asigServ;
	
	@Autowired
	private IEstudiantesServices estuServ;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<InscripcionesAsignaturas> inscripAsig = inscripServ.listarTodos();
		model.addAttribute("inscripciones", inscripAsig);
		return "/Administrator/InscripcionAsignaturalist";
	}
	 @GetMapping("/Create")
	    public String crear(Model model){
		 
		 InscripcionesAsignaturas inscripAsig = new InscripcionesAsignaturas();
	      
	        List<Asignaturas> asignatura = asigServ.listarTodos();
	        
	          List<Estudiantes> estudiante = estuServ.listarTodos();
	         
	        
	     
	       
	        model.addAttribute("asignaturas", asignatura);
	        model.addAttribute("inscripciones", inscripAsig);
	        model.addAttribute("estudiantes", estudiante);
	        
	        return "/Administrator/InscripcionesAsignaturaadd";
	    }
	    @PostMapping("/save")
	    public String guarda(@ModelAttribute InscripcionesAsignaturas user){
	    	inscripServ.guardar(user);
	        System.out.println("Registro registrado correctamente");
	        return "redirect:/Admin/Inscripciones/listar";
	    }
	    @GetMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Integer id,Model model){
	         List<Asignaturas> asignatura = asigServ.listarTodos();
	        
	          List<Estudiantes> estudiante = estuServ.listarTodos();
	          InscripcionesAsignaturas inscripAsig = inscripServ.buscaById(id);
	        model.addAttribute("titulo", "Lista de Docentes");
	     
	        model.addAttribute("inscripciones", inscripAsig);
	        model.addAttribute("asignaturas", asignatura);
	        model.addAttribute("estudiantes", estudiante);
	        
	        return "/Administrator/InscripcionesAsignaturaadd";
	    }
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable("id") Integer id,Model model){
	    	inscripServ.eliminar(id);
	        return "redirect:/Admin/Inscripciones/listar";
	    }
}
