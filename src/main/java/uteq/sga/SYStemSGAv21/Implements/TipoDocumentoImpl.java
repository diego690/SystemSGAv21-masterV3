/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Tipodocumento;
import uteq.sga.SYStemSGAv21.Repositorys.ITipoDocumentoRepository;
import uteq.sga.SYStemSGAv21.Services.ITipoDocumentoServices;

/**
 *
 * @author capur
 */
@Service
public class TipoDocumentoImpl implements ITipoDocumentoServices{
    
    @Autowired
    private ITipoDocumentoRepository tdrepo;

    @Override
    public List<Tipodocumento> listarTodos() {
        return (List<Tipodocumento>) tdrepo.findAll();
    }

    @Override
    public void guardar(Tipodocumento actividad) {
        tdrepo.save(actividad);
    }

    @Override
    public Tipodocumento buscaById(Integer id) {
        return tdrepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tdrepo.deleteById(id);
    }
    
}
