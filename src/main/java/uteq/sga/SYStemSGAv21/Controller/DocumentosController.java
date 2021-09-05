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
import uteq.sga.SYStemSGAv21.Entity.Documentos;
import uteq.sga.SYStemSGAv21.Entity.Representante;
import uteq.sga.SYStemSGAv21.Entity.Tipodocumento;
import uteq.sga.SYStemSGAv21.Services.IDocumentosServices;
import uteq.sga.SYStemSGAv21.Services.IRepresentanteServices;
import uteq.sga.SYStemSGAv21.Services.ITipoDocumentoServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/Documentos")
public class DocumentosController {
    
    @Autowired
    private IDocumentosServices docuserv;
    
    @Autowired
    private ITipoDocumentoServices tdserv;
    
    @Autowired
    private IRepresentanteServices represerv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Documentos> documentos = docuserv.listarTodos();
        model.addAttribute("titulo", "Lista de Documentos Registrados");
        model.addAttribute("documentos", documentos);
        return "/Administrator/Documentoslist";
    }
    @RequestMapping("/create")
    public String crear(Model model){
        Documentos documentos = new Documentos();
        List<Tipodocumento>  tipodocumento = tdserv.listarTodos();
        List<Representante> representante = represerv.listarTodos();
        model.addAttribute("titulo", "Ingreso Nuevo de Documentos");
        model.addAttribute("representante", representante);
        model.addAttribute("tipodocumento", tipodocumento);
        model.addAttribute("documentos", documentos);
        return "/Administrator/Documentosadd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Documentos user){
        docuserv.guardar(user);
        System.out.println("Registro exitoso guardado");
        return "redirect:/Admin/Documentos/listar";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
         Documentos documentos = docuserv.buscaById(id);
        List<Tipodocumento>  tipodocumento = tdserv.listarTodos();
        List<Representante> representante = represerv.listarTodos();
        model.addAttribute("titulo", "Ingreso Nuevo de Documentos");
        model.addAttribute("representante", representante);
        model.addAttribute("tipodocumento", tipodocumento);
        model.addAttribute("documentos", documentos);
        return "/Administrator/Documentosadd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
         docuserv.eliminar(id);
        System.out.println("Registro eliminado");
        return "redirect:/Admin/Documentos/listar";
    }
    
}
