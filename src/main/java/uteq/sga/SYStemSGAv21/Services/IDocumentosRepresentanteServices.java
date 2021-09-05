/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.DocumentoRepresentante;

/**
 *
 * @author capur
 */
public interface IDocumentosRepresentanteServices {
    public List<DocumentoRepresentante> listarTodos();
    public void guardar(DocumentoRepresentante actividad);
    public DocumentoRepresentante buscaById(Integer id);
    public void eliminar(Integer id);
}
