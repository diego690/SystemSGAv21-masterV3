/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Representante;
import uteq.sga.SYStemSGAv21.Repositorys.IRepresentanteRepository;
import uteq.sga.SYStemSGAv21.Services.IRepresentanteServices;

/**
 *
 * @author capur
 */
@Service
public class RepresentanteImpl implements IRepresentanteServices{
    
    @Autowired
    private IRepresentanteRepository reprerepo;

    @Override
    public List<Representante> listarTodos() {
        return (List<Representante>) reprerepo.findAll();
    }

    @Override
    public void guardar(Representante actividad) {
        reprerepo.save(actividad);
    }

    @Override
    public Representante buscaById(Integer id) {
        return reprerepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        reprerepo.deleteById(id);
    }
    
}
