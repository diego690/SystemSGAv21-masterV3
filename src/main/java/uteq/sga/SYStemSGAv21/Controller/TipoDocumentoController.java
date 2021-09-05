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
import uteq.sga.SYStemSGAv21.Entity.Tipodocumento;
import uteq.sga.SYStemSGAv21.Services.ITipoDocumentoServices;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin/TipoDocumento")
public class TipoDocumentoController {
    
    @Autowired
    private ITipoDocumentoServices tdserv;
    
    @RequestMapping("/listar")
    public String page(Model model) {
        List<Tipodocumento> tdocument = tdserv.listarTodos();
        model.addAttribute("titulo", "Lista de tipos de Documentos");
        model.addAttribute("tdocumento", tdocument);
        return "/Administrator/TipoDocumentoslist";
    }
    @RequestMapping("/create")
    public String crear(Model model){
        Tipodocumento tdocument = new Tipodocumento();
        model.addAttribute("titulo", "Nuevo Tipo Documento");
        model.addAttribute("tdocumento", tdocument);
        return "/Administrator/TipoDocumentoAdd";
    }
    @PostMapping("/save")
    public String guarda(@ModelAttribute Tipodocumento user){
        tdserv.guardar(user);
        System.out.println("Registro guardado Exitosamente");
        return "redirect:/Admin/TipoDocumento/listar";
    }
    @RequestMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Tipodocumento tdocument = tdserv.buscaById(id);
        model.addAttribute("titulo", "Edición Tipo Documento");
        model.addAttribute("tdocumento", tdocument);
        return "/Administrator/TipoDocumentoAdd";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        tdserv.eliminar(id);
        return "redirect:/Admin/TipoDocumento/listar";
    }
}
