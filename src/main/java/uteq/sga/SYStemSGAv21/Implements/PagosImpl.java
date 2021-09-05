/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Pagos;
import uteq.sga.SYStemSGAv21.Repositorys.IPagosRepository;
import uteq.sga.SYStemSGAv21.Services.IPagosServices;

/**
 *
 * @author capur
 */
@Service
public class PagosImpl implements IPagosServices{
    
    @Autowired
    private IPagosRepository pgrepo;

    @Override
    public List<Pagos> listarTodos() {
        return (List<Pagos>) pgrepo.findAll();
    }

    @Override
    public void guardar(Pagos actividad) {
        pgrepo.save(actividad);
    }

    @Override
    public Pagos buscaById(Integer id) {
        return pgrepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        pgrepo.deleteById(id);
    }
    
}
