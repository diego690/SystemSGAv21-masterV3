/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.DocumentosEstudiante;
import uteq.sga.SYStemSGAv21.Services.IDocumentosEstudianteServices;

/**
 *
 * @author capur
 */
@Service
public class DocumentosEstudianesImpl implements IDocumentosEstudianteServices{

    @Override
    public List<DocumentosEstudiante> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(DocumentosEstudiante actividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DocumentosEstudiante buscaById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
