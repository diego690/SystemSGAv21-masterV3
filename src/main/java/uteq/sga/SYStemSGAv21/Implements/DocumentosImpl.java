/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Documentos;
import uteq.sga.SYStemSGAv21.Repositorys.IDocumentosRepository;
import uteq.sga.SYStemSGAv21.Services.IDocumentosServices;

/**
 *
 * @author capur
 */
@Service
public class DocumentosImpl implements IDocumentosServices{
    
    @Autowired
    private IDocumentosRepository docurepo;

    @Override
    public List<Documentos> listarTodos() {
        return (List<Documentos>) docurepo.findAll();
    }

    @Override
    public void guardar(Documentos actividad) {
        docurepo.save(actividad);
    }

    @Override
    public Documentos buscaById(Integer id) {
        return docurepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        docurepo.deleteById(id);
    }
    
}
