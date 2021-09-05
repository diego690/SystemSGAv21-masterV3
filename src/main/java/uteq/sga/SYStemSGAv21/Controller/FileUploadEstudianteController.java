/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Entity.DocumentosEstudiante;
import uteq.sga.SYStemSGAv21.Entity.EntregaTareas;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;
import uteq.sga.SYStemSGAv21.Services.IDocumentosEstudianteServices;
import uteq.sga.SYStemSGAv21.Services.IEntregaTareasServices;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Archivo/Estudiante")
public class FileUploadEstudianteController {
    
     @Autowired
    private IEntregaTareasServices ent_tar_rep;
    
    @Autowired
    private IAsignaturaServices ent_tra_asig;
    
    @Autowired
    private IEstudiantesServices ent_tra_est;
    
    @Autowired
    private IDocumentosEstudianteServices doces;
    
    public String ruta;
    public String nombrearchivo ="TR-ES-" + UUID.randomUUID();
    
    @GetMapping("/subir/{id}")
    public String index(@PathVariable("id") Integer id,Model model,@RequestParam (required=false,value="paht") String paht){
        StringBuilder builder=new StringBuilder();
        builder.append(System.getProperty("user.dir"));
        builder.append(File.separator);
        builder.append("src\\main\\resources\\fileestudiantes");
        builder.append(File.separator);
        builder.append(nombrearchivo);
        ruta=builder.toString();
        paht=nombrearchivo;
        DocumentosEstudiante estudiante = new DocumentosEstudiante();
        EntregaTareas document = ent_tar_rep.buscaById(id);
        document.setArchivo(paht);
        List<Estudiantes> estud=ent_tra_est.listarTodos();
        List<Asignaturas> asig=ent_tra_asig.listarTodos();
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("estud",estud);
        model.addAttribute("asig",asig);
        model.addAttribute("documentos",estudiante);
        model.addAttribute("tareasd", document);
        model.addAttribute("paht", paht);
        return "Student/UploadEstudiante";
    } 
    
    @PostMapping("/upload/{id}")
    public String uploadFile(@RequestParam("file") MultipartFile file,@PathVariable("id") Integer id,Model model,@ModelAttribute EntregaTareas ingresar) throws IOException{
        if(file==null||file.isEmpty()){
            return "Student/EntregaTareaslist";
        }
        ent_tar_rep.guardar(ingresar);
        byte[] fileBytes = file.getBytes();
        Path path=Paths.get(ruta);
        Files.write(path,fileBytes);
        
        DocumentosEstudiante estudiante = new DocumentosEstudiante();
        EntregaTareas document = ent_tar_rep.buscaById(id);
        List<Estudiantes> estud=ent_tra_est.listarTodos();
        List<Asignaturas> asig=ent_tra_asig.listarTodos();
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("documentos",estudiante);
        model.addAttribute("estud",estud);
        model.addAttribute("asig",asig);
        model.addAttribute("tareas", document);
        return "Student/EntregaTareaslist";
    } 
    
    @PostMapping("/save")
    public String guarda(@ModelAttribute DocumentosEstudiante user){
        doces.guardar(user);
        return "Student/EntregaTareaslist";
    }
    
    @GetMapping("/entregar/{id}")
    public String status(@PathVariable("id") Integer id,Model model){
        EntregaTareas document = ent_tar_rep.buscaById(id);
        List<Estudiantes> estud=ent_tra_est.listarTodos();
        List<Asignaturas> asig=ent_tra_asig.listarTodos();
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("estud",estud);
        model.addAttribute("asig",asig);
        model.addAttribute("tareas", document);
        return "Student/EntregaTareasadd";
    }
    
}
