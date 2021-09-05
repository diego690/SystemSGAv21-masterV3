/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Carreras;
import uteq.sga.SYStemSGAv21.Repositorys.ICarreraRepository;
import uteq.sga.SYStemSGAv21.Services.ICarrerasServices;

/**
 *
 * @author capur
 */
@Service
public class CarrerasImpl implements ICarrerasServices{
    
    @Autowired
    private ICarreraRepository carrepo;

    @Override
    public List<Carreras> listarTodos() {
        return (List<Carreras>) carrepo.findAll();
    }

    @Override
    public void guardar(Carreras actividad) {
        carrepo.save(actividad);
    }

    @Override
    public Carreras buscaById(Integer id) {
        return carrepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        carrepo.deleteById(id);
    }
    
}
